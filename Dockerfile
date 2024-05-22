#
# Build
#
#FROM maven:3.8.4-eclipse-temurin-11 AS build-service
FROM maven:3.9.6-eclipse-temurin-17 AS build-service
COPY . /webapi
RUN mvn -f /webapi/pom.xml clean package -Dmaven.test.skip

#
# Run
#
#FROM eclipse-temurin:11.0.14.1_1-jre-focal
FROM eclipse-temurin:17.0.11_9-jre
COPY --from=build-service /webapi/target/webapi-0.0.1-SNAPSHOT.jar /usr/local/lib/webapi.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/webapi.jar"]
