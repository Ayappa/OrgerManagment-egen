FROM openjdk:8
ADD target/egen-0.0.1-SNAPSHOT.jar docker-spring-boot.jar
EXPOSE 8080
VOLUME /tmps
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]