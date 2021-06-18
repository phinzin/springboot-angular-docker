# FROM openjdk:8-jdk-alpine
#
# ADD api/target/*.war shop.war
#
# ENV port=8080
#
# ENTRYPOINT ["java","-jar","shop.war"]

FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./api/target/*.war /usr/local/tomcat/webapps/shop.war