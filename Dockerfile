FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY . .

ENTRYPOINT ["java", "-jar" , "mail-send-1.0.0.jar"]