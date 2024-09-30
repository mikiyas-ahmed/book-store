# the base image
FROM amazoncorretto:21

# Add a volume pointing to /tmp
VOLUME /tmp

# Define build argument for the JAR file
ARG JAR_FILE=build/libs/*.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Expose port 8080
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]
