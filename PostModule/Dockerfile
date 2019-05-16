FROM alpine:edge
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./PostModule/target/PostModule-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./PostModule/post-entrypoint.sh /opt/bin/post-entrypoint.sh
RUN chmod 755 /opt/bin/post-entrypoint.sh
EXPOSE 1234
