FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD api-gateway-1.3.0-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api-gateway.jar"]
EXPOSE 9090