FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./build/libs/backend-fight-0.0.1-SNAPSHOT.jar ./main.jar

EXPOSE 8000

ENTRYPOINT [ "java", "-jar", "./main.jar" ]
