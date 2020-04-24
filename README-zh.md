# Spring-Cloud-Learning

[![Build Status](https://travis-ci.org/coderqianlq/spring-cloud-learning.svg?branch=master)](https://travis-ci.org/coderqianlq/spring-cloud-learning)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Coverage Status](https://coveralls.io/repos/github/coderqianlq/spring-cloud-learning/badge.svg?branch=master)](https://coveralls.io/github/coderqianlq/spring-cloud-learning?branch=master)

README: [English](README.md) | [中文](README-zh.md)

spring-cloud-learning适合刚接触微服务架构的初学者用来初步了解和学习微服务，主要集成了注册中心，服务网关，配置中心，熔断机制和应用监控。

## 目录

* [微服务组件](#微服务组件)
* [Getting Started](#getting-started)
  * [本地启动（推荐）](#本地启动（推荐）)
  * [Docker启动](#Docker启动)
* [截图预览](#截图预览)
* [模块预览](#模块预览)
* [依赖版本](#依赖版本)
* [Todo List](#todo-list)
* [Collaborators](#collaborators)
* [License](#license)

## 微服务组件

- [x] Eureka
- [x] Consul
- [ ] Ribbon
- [x] Feign
- [x] Hystrix
- [x] Turbine
- [x] Zuul
- [x] Spring Cloud Config
- [x] Spring Cloud Stream
- [x] Spring Cloud Bus
- [ ] Spring Cloud Sleuth
- [ ] Spring Cloud Security
- [ ] Spring Cloud Task

补充中...

## Getting Started

主要介绍两种启动方式，现在还是推荐本地启动，Docker还在学习中，而且服务比较多，现在只配置了几个主要的服务。

首先克隆代码到本地。

```
$ git clone https://github.com/coderqianlq/spring-cloud-learning.git
```

### 本地启动（推荐）

使用IDE以maven方式打开项目，并使用IDE或者命令行启动项目。

```
$ mvn spring-boot:run
```

或者打包项目后使用jar命令启动。

```
$ java -jar xxx.jar
```

### Docker启动

首先，确认已经安装docker并启动它。

```
$ docker --version
Docker version 18.06.1-ce, build e68fc7a
```

然后，进入每个子模块执行docker构建命令。

```
$ cd eureka-server

$ mvn clean package -Pdocker docker:build
```

接着，返回父模块执行docker-compose命令。

```
$ docker-compose up -d
```

最后，你可以打开注册中心（默认url: [http://localhost:8761](http://localhost:8761)）查看服务是否注册成功。

## 截图预览

![Spring boot admin wallboard](screenshots/Spring%20boot%20admin%20wallboard.png)

![Spring Boot admin detail](screenshots/Spring%20boot%20admin%20detail.png)

![Service customer hystrix stream](screenshots/Service%20customer%20hystrix%20stream.png)

![Hystrix monitor](screenshots/Hystrix%20monitor.png)

## 模块预览

|      -            |     port     |     remarks     |
| :-------------    | :----------: | :-------------: |
| api-gateway       |     9090     |                 |
| config-server     |     8504     | 如果修改了该模块端口，你需要同时修改service-customer模块的bootstrap.yml配置中心的端口 |
| consul-server     |     8502     |                 |
| eureka-server     |     8761     |                 |
| feign-server      |     8765     | 应该没啥用，有时间会把它删了 |
| hystrix-dashboard |     8050     |                 |
| service-customer  |     8200     | 集成了多个组件的使用，包括Feign, Spring Cloud Config, Spring Cloud Stream, Spring Cloud Bus, 后面有时间拆出去 |
| service-core      |     8100     |                 |
| turbine-server    |     8060     |                 |
| zipkin-server     |     9411     | 同config-server的备注 |

## 依赖版本

| Spring Boot | Spring Cloud | Spring Boot Admin | Swagger2 |
| :---------: | :----------: | :---------------: | :------: |
|    2.1.5    |   Greenwich  |       2.1.6       |   2.7.0  |

## Todo List

- [ ] 拆分service-customer服务（这个服务太笨重了，一开始想着自个练习用，不利于初学Spring Cloud的程序员👨‍💻们‍使用）.
- [x] 添加监控hystrix和集群监控turbine的详细用法.
- [x] 升级Spring Boot 2.0, 同时升级Spring Cloud Greenwich.
- [x] 添加Spring Boot admin dashboard.

## Collaborators

<!-- https://github.com/all-contributors/all-contributors -->
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Marveliu">
      <img src="https://avatars3.githubusercontent.com/u/15508722?v=4" width="100" alt=""/>
      <br />
      <sub><b>Marveliu</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Joby1230">
      <img src="https://avatars3.githubusercontent.com/u/23372369?v=4" width="100" alt=""/>
      <br />
      <sub><b>Joby1230</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/wxaaaa">
      <img src="https://avatars3.githubusercontent.com/u/19554712?&v=4" width="100" alt=""/>
      <br />
      <sub><b>wxaaaa</b></sub>
      </a>
    </td>
  </tr>
</table>

## License
[MIT](LICENSE) © CoderQian