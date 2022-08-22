FROM openjdk:11.0.16-oracle
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
