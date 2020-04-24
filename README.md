# Spring-Cloud-Learning

[![Build Status](https://travis-ci.org/coderqianlq/spring-cloud-learning.svg?branch=master)](https://travis-ci.org/coderqianlq/spring-cloud-learning)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Coverage Status](https://coveralls.io/repos/github/coderqianlq/spring-cloud-learning/badge.svg?branch=master)](https://coveralls.io/github/coderqianlq/spring-cloud-learning?branch=master)

README: [English](README.md) | [中文](README-zh.md)

spring-cloud-learning can be used as a project to learn microservices, and it's mainly contain service discovery, service gateway, configuration management, circuit breakers, application monitor.

## Table of Contents

* [Components](#components)
* [Getting Started](#getting-started)
  * [Use directly (recommend)](#use-directly-recommend)
  * [Use docker](#use-docker)
* [Preview](#preview)
* [Modules](#modules)
* [Dependency Chart](#dependency-chart)
* [Todo List](#todo-list)
* [Collaborators](#collaborators)
* [License](#license)

## Components

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

To be supplemented...

## Getting Started

Two methods will mainly introduced, but no matter what you need to clone the code.

```
$ git clone https://github.com/coderqianlq/spring-cloud-learning.git
```

### Use directly (recommend)

You can use ide to import the project with maven, and use ide or use command line to start project.

```
$ mvn spring-boot:run
```

You can also package the code and run it.

```
$ java -jar xxx.jar
```

### Use docker

First, you have to make sure you have installed docker and start docker server.

```
$ docker --version
Docker version 18.06.1-ce, build e68fc7a
```

Then, you need to enter each submodule and execute the docker building command.

```
$ cd eureka-server

$ mvn clean package -Pdocker docker:build
```

Next, return to the parent module and execute docker-compose command.

```
$ docker-compose up -d
```

Finally, you can open the registration center(default url: http://localhost:8761) to see if the service is registered successfully.

## Preview

![Spring boot admin wallboard](screenshots/Spring%20boot%20admin%20wallboard.png)

![Spring Boot admin detail](screenshots/Spring%20boot%20admin%20detail.png)

![Service customer hystrix stream](screenshots/Service%20customer%20hystrix%20stream.png)

![Hystrix monitor](screenshots/Hystrix%20monitor.png)

## Modules

|      -            |     port     |     remarks     |
| :-------------    | :----------: | :-------------: |
| api-gateway       |     9090     |                 |
| config-server     |     8504     | if you change the port, you need also modify bootstrap.yml of service-customer. |
| consul-server     |     8502     |                 |
| eureka-server     |     8761     |                 |
| feign-server      |     8765     | The simple use of Hystrix is in this module. |
| hystrix-dashboard |     8050     |                 |
| service-customer  |     8200     | Integrated multiple components, including Feign, Spring Cloud Config, Spring Cloud Stream, Spring Cloud Bus |
| service-core      |     8100     |                 |
| turbine-server    |     8060     |                 |
| zipkin-server     |     9411     | if you change the port, you need also modify bootstrap.yml of service-customer. |

## Dependency Chart

| Spring Boot | Spring Cloud | Spring Boot Admin | Swagger2 |
| :---------: | :----------: | :---------------: | :------: |
|    2.1.5    |   Greenwich  |       2.1.6       |   2.7.0  |

## Todo List

- [ ] Split the module of service-customer.
- [x] Add the detailed usage of hystrix with turbine.
- [x] Update Spring Boot to 2.x and both Spring Cloud to Greenwich.
- [x] Add Spring Boot admin dashboard.

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