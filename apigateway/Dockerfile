FROM openjdk:8
MAINTAINER javaonfly
RUN apt-get update && apt-get -y install netcat && apt-get clean
COPY ./apigateway/target/apigateway-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./apigateway/apigateway-entrypoint.sh /opt/bin/apigateway-entrypoint.sh
RUN chmod 755 /opt/bin/apigateway-entrypoint.sh
EXPOSE 8084
