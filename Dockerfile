FROM maven:3.8.6-openjdk-8-slim AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2  mvn clean package -DskipTests

FROM openjdk:8-jre
ADD api/target/*.jar shop.jar
ENV port=8080
ENTRYPOINT ["java","-Dserver.port=$PORT $JAVA_OPTS -jar","shop.jar"]
