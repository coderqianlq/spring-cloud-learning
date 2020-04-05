## Spring-Cloud-Learning 

[![Build Status](https://travis-ci.org/coderqianlq/spring-cloud-learning.svg?branch=master)](https://travis-ci.org/coderqianlq/spring-cloud-learning)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/coderqianlq/spring-cloud-learning/blob/master/LICENSE)
[![Coverage Status](https://coveralls.io/repos/github/coderqianlq/spring-cloud-learning/badge.svg)](https://coveralls.io/github/coderqianlq/spring-cloud-learning)

## Contents

* [Usage](#usage)
  * [Use directly](#use-directly)
  * [Use docker](#use-docker)
* [Components](#components)
* [Modules](#modules)
* [Releases](#releases)
* [Todo](#todo)
* [Links](#links)
* [Collaborators](#collaborators)
* [License](#license)

## Usage

Two methods will mainly introduced, but no matter what you need to clone the code.

```
$ git clone https://github.com/coderqianlq/spring-cloud-learning.git
```

### Use directly

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

Then, you need to enter each sub module and execute the docker building command.

```
$ cd eureka-server

$ mvn clean package -Pdocker docker:build
```

Next, return to the parent module and execute docker-compose command.

```
$ docker-compose up -d
```

Finally, you can open the registration center(default url: http://localhost:8761) to see if the service is registered successfully.

## Components

- [x] Eureka
- [x] Consul
- [ ] Ribbon
- [x] Feign
- [ ] Hystrix
- [ ] Turbine
- [x] Zuul
- [x] Spring Cloud Config
- [x] Spring Cloud Stream
- [x] Spring Cloud Bus
- [ ] Spring Cloud Sleuth
- [ ] Spring Cloud Security
- [ ] Spring Cloud Task

To be supplemented...

## Modules

|      -           |     port     |     remarks     |
| :-------------   | :----------: | :-------------: |
| api-gateway      |     9090     |                 |
| config-server    |     8504     | if you change the port, you need also modify bootstrap.yml of service-customer. |
| consul-server    |     8502     |                 |
| eureka-server    |     8761     |                 |
| feign-server     |     8765     | The simple use of Hystrix is in this module. |
| service-customer |     8200     | Integrated multiple components, including Feign, Spring Cloud Config, Spring Cloud Stream, Spring Cloud Bus |
| service-producer |     8100     |                 |
| zipkin-server    |     9411     | if you change the port, you need also modify bootstrap.yml of service-customer. |

## Releases

| Spring Boot | Spring Cloud | Swagger2 |
| :---------: | :----------: | :------: |
|    1.5.9    |    Dalston   |   2.7.0  |

## Todo

- [ ] Split the module of service-customer.
- [ ] Add the detailed usage of hystrix with turbine.
- [ ] Update Spring Boot to 2.x and both Spring Cloud to Greenwich.

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

## Links
[Léon's Notes](https://www.qianlq.com/)

## License
[MIT](https://github.com/coderqianlq/spring-cloud-learning/blob/master/LICENSE) © CoderQian