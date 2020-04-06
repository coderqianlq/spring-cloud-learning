FROM frolvlad/alpine-oraclejdk8:slim

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

VOLUME /tmp
ADD service-customer-2.1.0-SNAPSHOT.jar service-customer.jar
ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "http://config-server:8504/health", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service-customer.jar"]
EXPOSE 8200