FROM openjdk:11
MAINTAINER javaonfly
COPY ./servicediscovery/target/servicediscovery-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/servicediscovery-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761
