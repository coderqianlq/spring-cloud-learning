FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD service-customer-2.1.0-SNAPSHOT.jar service-customer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-customer.jar"]
EXPOSE 8200