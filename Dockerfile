FROM openjdk:8-jdk-alpine
ADD api/target/*.jar shop.jar
ENV port=8080
ENTRYPOINT ["java","-Dserver.port=$PORT $JAVA_OPTS -jar","shop.jar"]
