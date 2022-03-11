FROM adoptopenjdk/openjdk11:ubi
LABEL Rodrigo Pires
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]