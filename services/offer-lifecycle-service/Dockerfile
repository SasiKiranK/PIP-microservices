# Stage 1: Build the project with Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app using built jar
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/offer-lifecycle-service-1.0-SNAPSHOT.jar app.jar
COPY config.yml config.yml
CMD ["java", "-jar", "app.jar", "server", "config.yml"]
