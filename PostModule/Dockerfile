FROM openjdk:8
MAINTAINER javaonfly
RUN apt-get update && apt-get -y install netcat && apt-get clean
COPY ./PostModule/target/PostModule-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./PostModule/post-entrypoint.sh /opt/bin/post-entrypoint.sh
RUN chmod 755 /opt/bin/post-entrypoint.sh
EXPOSE 8761
