FROM openjdk:17
ADD target/assessment.jar assessment.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/assessment.jar"]
