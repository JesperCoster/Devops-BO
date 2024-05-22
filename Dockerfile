# Stage 1: Build
FROM maven:3.8.5-eclipse-temurin-21 AS builder

# Set the working directory in the build stage
WORKDIR /build

# Copy the Maven pom.xml file and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Production
FROM eclipse-temurin:21-jdk

# Set the working directory in the production stage
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=builder /build/target/BoApp-*.jar /app/BoApp.jar

EXPOSE 8080

CMD ["java", "-jar", "BoApp.jar"]
