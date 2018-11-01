<div align="center">
  <img src="https://image.ibb.co/fY9Lte/Spring_Logos_CLOUD_HOR.png" width="80%"/>
	<br/>
	
  [![Build Status](https://travis-ci.org/coderqianlq/spring-cloud-cli.svg?branch=master)](https://travis-ci.org/coderqianlq/spring-cloud-cli)
  [![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/coderqianlq/spring-cloud/blob/master/LICENSE)
</div>

**1. Spring Cloud简介**

Spring Cloud是一个基于Spring Boot实现的云应用开发工具，它为基于JVM的云应用开发中涉及的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等操作提供了一种简单的开发方式。

Spring Cloud 全家桶：

<center>
    <table width="800">
	<tr><td width="300">服务注册中心</td><td width="500">Spring Cloud Netflix Eureka</td></tr>
	<tr><td width="300">服务调用方式</td><td width="500">REST API</td></tr>
	<tr><td width="300">服务网关</td><td width="500">Spring Cloud Netflix Zuul</td></tr>
        <tr><td width="300">断路器</td><td width="500">Spring Cloud Netflix Hystrix</td></tr>
        <tr><td width="300">分布式配置</td><td width="500">Spring Cloud Config</td></tr>
        <tr><td width="300">服务跟踪</td><td width="500">Spring Cloud Sleuth</td></tr>
	<tr><td width="300">消息总线</td><td width="500">Spring Cloud Bus</td></tr>
	<tr><td width="300">数据流</td><td width="500">Spring Cloud Stream</td></tr>
	<tr><td width="300">批量任务</td><td width="500">Spring Cloud Task</td></tr>
    </table>
</center>

**2. 微服务架构**

微服务架构就是将一个完整的应用从数据存储开始垂直拆分成多个不同的服务，每个服务都能独立部署、独立维护、独立扩展，服务与服务间通过诸如RESTful API的方式互相调用。各个微服务之间是松耦合的，每个微服务仅关注于完成一件任务，每个任务代表着一个小的业务能力。

**3. 服务治理**

服务治理是实现微服务的关键。那么有没有好的服务治理方案呢？我想大家都听过或者使用过dubbo，dubbo就是一个带有服务治理功能的RPC框架。dubbo提供了一套较为完整的服务治理方案，所以企业如果要实现服务化的话，dubbo是很好的一个选择。

服务发现与注册作为服务治理最最重要的问题，dubbo中引入了一个注册中心的概念，而zookeeper作为dubbo推荐的注册中心，承担了及其重要的作用。

那么我们如何使用Spring Cloud来实现服务治理呢？答案就是Spring Cloud Eureka，也就是本篇博客要介绍的重点。Spring Cloud Eureka是Spring Cloud Netflix项目下的服务治理模块。而Spring Cloud Netflix项目是Spring Cloud的子项目之一，主要内容是对Netflix公司一系列开源产品的包装，它为Spring Boot应用提供了自配置的Netflix OSS整合。通过一些简单的注解，开发者就可以快速的在应用中配置一下常用模块并构建庞大的分布式系统。它主要提供的模块包括：服务发现（Eureka），断路器（Hystrix），智能路由（Zuul），客户端负载均衡（Ribbon）等。

以下是笔者翻阅资料后对zookeeper和eureka进行的比较总结：

* Eureka 保证AP
Eureka中各个节点都是平等的，几个节点挂掉不会影响正常节点的工作，剩余节点依然可以提供注册和查询服务。而Eureka的客户端在向某个Eureka注册时如果发现连接失败，则会自动切换至其它节点，从而保证注册服务可用（保证可用性），只不过查到的信息可能不是最新的（不保证强一致性）。除此之外，Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就认为客户端与注册中心出现了网络故障，此时会出现以下几种情况：
   1. Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务。
   2. Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上（即保证当前节点依然可用）。
   3. 当网络稳定时，当前Eureka新的注册信息会被同步到其它节点中。

  **Eureka还有客户端缓存功能**

* <font size=3>Zookeeper 保证CP
当master节点因为网络故障与其他节点失去联系时，剩余节点会重新进行leader选举。在选举期间整个zk集群都是不可用的，这就导致在选举期间注册服务瘫痪。</font>


**4. 动手搭服务发现和注册**

**第一步：创建服务注册中心**

创建Spring boot项目，命名为eureka-server，并在pom.xml中引入需要的依赖内容：
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<!-- 引入Eureka服务包-->
<dependencies>
	<dependency>
	    <groupId>org.springframework.cloud</groupId>
	    <artifactId>spring-cloud-starter-eureka-server</artifactId>
	</dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Dalston.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话。在Spring Boot启动类加上这个注解即可，如下：
```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
```

在默认设置下，该服务注册中心也会将自己作为客户端来尝试注册它自己，所以我们需要禁用它的客户端注册行为，只需要在application.properties配置文件中增加如下信息：
```java
spring.application.name=eureka-server
server.port=8761
eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka
#表示是否将自己注册到Eureka Server上，默认为true
eureka.client.registerWithEureka=false
#表示是否从Eureka Server上获取注册信息，默认为true
eureka.client.fetchRegistry=false
```

启动工程，访问 http://localhost:8761/ ，可以看到下面的页面，其中还没有发现任何服务。
![](https://preview.ibb.co/de5V7U/2018_09_29_4_34_31_2.png)

**第二步：创建服务提供方**

下面我们创建提供服务的客户端，并向服务注册中心注册自己。本文我们主要介绍服务的注册与发现，所以我们不妨在服务提供方中尝试着提供一个接口来获取当前所有的服务信息。

首先，创建一个基本的Spring Boot应用。命名为eureka-order，在pom.xml中，加入如下配置：
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>

<dependencies>
	<dependency>
	    <groupId>org.springframework.cloud</groupId>
	    <artifactId>spring-cloud-starter-eureka</artifactId>
	</dependency>
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Dalston.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

在应用启动类中通过加上@EnableEurekaClient（该注解上有@EnableDiscoveryClient）注解，该注解能激活Eureka中的DiscoveryClient实现，这样才能实现Controller中对服务信息的输出。
```java
@SpringBootApplication
@EnableEurekaClient
public class EurekaOrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaOrderApplication.class, args);
	}
}
```

我们在完成以上工作后，再继续对eureka-order的application.properties做一些配置工作，具体如下：
```java
spring.application.name=eureka-order
server.port=8100
eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka
```

通过spring.application.name属性，我们可以指定微服务的名称后续在调用的时候只需要使用该名称就可以进行服务的访问。eureka.client.serviceUrl.defaultZone属性对应服务注册中心的配置内容，指定服务注册中心的位置。为了在本机上测试区分服务提供方和服务注册中心，使用server.port属性设置不同的端口。

同时启动两个服务，再访问 http://localhost:8761/  出现下图内容则表示服务注册成功：
![](https://preview.ibb.co/kvyTu9/2018_09_29_4_53_47_2.png)

这样就基本完成了基础的Spring Cloud搭建。Spring Cloud其它组件的搭建的程可参考[我的博客](https://blog.csdn.net/weixin_36759405)。


