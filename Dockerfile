FROM maven:3.8.6-openjdk-8-slim AS build

RUN ls
WORKDIR /app
RUN ls
COPY pom.xml .
COPY api .
COPY web .
RUN --mount=type=cache,target=/root/.m2  mvn -f pom.xml clean install -DskipTests
RUN ls

FROM openjdk:8-jre
RUN ls
WORKDIR /app
RUN ls -l
ADD *.jar shop.jar
ENV port=8080
ENTRYPOINT ["java","-Dserver.port=$PORT $JAVA_OPTS -jar","shop.jar"]
