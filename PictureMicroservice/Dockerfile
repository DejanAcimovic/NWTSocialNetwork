FROM openjdk:8
MAINTAINER javaonfly
RUN apt-get update && apt-get -y install netcat && apt-get clean
COPY ./PictureMicroservice/target/picturemodel-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./PictureMicroservice/picture-entrypoint.sh /opt/bin/picture-entrypoint.sh
RUN chmod 755 /opt/bin/picture-entrypoint.sh
EXPOSE 4321
