# Stage 1: Build
FROM openjdk:21-jdk-slim AS build

# Install Maven
RUN apt-get update -y && \
    apt-get install -y maven

# Set the working directory in the build stage
WORKDIR /build

# Copy the Maven pom.xml file and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Stage 2: Production
FROM openjdk:21-jdk-slim

# Set the working directory in the production stage
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /build/target/BoApp-*.jar /app/BoApp.jar

EXPOSE 8080

CMD ["java", "-jar", "BoApp.jar"]
