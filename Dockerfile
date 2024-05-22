FROM maven:3.8.5-openjdk-18-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src


FROM openjdk:22-jdk-oracle
WORKDIR /app
COPY --from=builder /app/target/UserService-1.0.0.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]