FROM alpine:edge
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./UserMicroservice/target/usermodule-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./UserMicroservice/user-entrypoint.sh /opt/bin/user-entrypoint.sh
RUN chmod 755 /opt/bin/user-entrypoint.sh
EXPOSE 8000
