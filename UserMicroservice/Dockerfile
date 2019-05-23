FROM openjdk:8
MAINTAINER javaonfly
RUN apt-get update && apt-get -y install netcat && apt-get clean
COPY ./UserMicroservice/target/usermodule-0.0.1-SNAPSHOT.jar /opt/lib/
COPY ./UserMicroservice/user-entrypoint.sh /opt/bin/user-entrypoint.sh
RUN chmod 755 /opt/bin/user-entrypoint.sh
EXPOSE 8000
