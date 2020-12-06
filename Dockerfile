FROM openjdk:8-jdk-alpine
RUN addgroup -S rdp && adduser -S rdp -G rdp
USER rdp:rdp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} open-weather-forecast.jar
ENTRYPOINT ["java","-jar","/open-weather-forecast.jar"]