<div align="center">
  <img src="./Spring_Logos_CLOUD_HOR.png" width="80%"/>
	<br/>
	
  [![Build Status](https://travis-ci.org/coderqianlq/spring-cloud-cli.svg?branch=master)](https://travis-ci.org/coderqianlq/spring-cloud-cli)
  [![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/coderqianlq/spring-cloud/blob/master/LICENSE)
</div>

**快速开始**

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

**创建服务注册中心**

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
```properties
spring.application.name=eureka-server
server.port=8761
eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka
#表示是否将自己注册到Eureka Server上，默认为true
eureka.client.registerWithEureka=false
#表示是否从Eureka Server上获取注册信息，默认为true
eureka.client.fetchRegistry=false
```

启动工程，访问 http://localhost:8761/ 。

**创建服务提供方**

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
```properties
spring.application.name=eureka-order
server.port=8100
eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka
```

通过spring.application.name属性，我们可以指定微服务的名称后续在调用的时候只需要使用该名称就可以进行服务的访问。eureka.client.serviceUrl.defaultZone属性对应服务注册中心的配置内容，指定服务注册中心的位置。为了在本机上测试区分服务提供方和服务注册中心，使用server.port属性设置不同的端口。

同时启动两个服务，再访问 http://localhost:8761/ 。

**友情链接**

Spring Cloud其它组件的搭建教程可参考[我的博客](https://blog.csdn.net/weixin_36759405)。


