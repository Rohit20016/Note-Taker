FROM  maven:3.8.3-openjdk-17 AS builder
WORKDIR /app
COPY . /app
RUN mvn clean install -DSkipTests=True

FROM openjdk:17-alpine

WORKDIR /app
COPY --from=builder /app/target/*.jar /app/target/LIBMANAGEMENT.jar
ENTRYPOINT [ "java","-jar","/app/target/LIBMANAGEMENT.jar" ]