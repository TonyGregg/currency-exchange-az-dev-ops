FROM maven:3-adoptopenjdk-11
VOLUME /tmp
EXPOSE 8080
ADD target/*.jar currexchange.jar
ENTRYPOINT [ "sh", "-c", "java -jar /currexchange.jar" ]