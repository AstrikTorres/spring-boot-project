FROM maven:latest AS mvn
WORKDIR /app
COPY pom.xml .
RUN mvn -B -f pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY . .
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package -DskipTests

FROM openjdk:11.0.16-oracle
WORKDIR /app
COPY --from=mvn /app/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
