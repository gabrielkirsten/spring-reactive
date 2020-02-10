FROM maven:3.6.1-jdk-11-slim as build-stage

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app

RUN mvn dependency:go-offline
RUN mvn clean install

FROM openjdk:11-jre-slim-sid as run-stage

COPY --from=build-stage /usr/src/app/target/demo-web-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]