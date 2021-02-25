# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:11.0-jdk-oraclelinux7
# copy application WAR (with libraries inside)
COPY target/backendExamOne*.jar /app.jar
EXPOSE 7070
# specify default command
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]