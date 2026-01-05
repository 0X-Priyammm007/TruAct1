FROM openjdk:21-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Install Maven and build the application
RUN apt-get update && apt-get install -y maven && \
    mvn clean package -DskipTests

# Expose the application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "target/TruAct-1.0-SNAPSHOT.jar"]