FROM openjdk:17
LABEL authors="arungovindm"

WORKDIR /app
COPY target/assessment-0.0.1-SNAPSHOT.jar assessment-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "assessment-0.0.1-SNAPSHOT.jar"]
