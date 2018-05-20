FROM openjdk:8
COPY /oregano/build/libs/oregano-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar oregano-0.0.1-SNAPSHOT.jar