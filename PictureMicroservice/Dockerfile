FROM alpine-jdk:base
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./PictureMicroservice/target/picturemodel-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./PictureMicroservice/picture-entrypoint.sh /opt/bin/picture-entrypoint.sh
RUN chmod 755 /opt/bin/picture-entrypoint.sh
EXPOSE 4321
