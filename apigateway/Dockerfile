FROM alpine:edge
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./apigateway/target/apigateway-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./apigateway/apigateway-entrypoint.sh /opt/bin/apigateway-entrypoint.sh
RUN chmod 755 /opt/bin/apigateway-entrypoint.sh
EXPOSE 8084
