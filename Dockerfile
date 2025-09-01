FROM amazoncorretto:21
WORKDIR /app
COPY build/libs/notification-0.0.1-SNAPSHOT.jar /app/notification.jar
EXPOSE 8082
CMD ["java", "-jar", "/app/notification.jar"]