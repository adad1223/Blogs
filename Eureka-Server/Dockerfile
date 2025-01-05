FROM openjdk:latest
MAINTAINER "Anish Rishi"
ADD target/eurekaserver.jar eurekaserver.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eurekaserver.jar"]