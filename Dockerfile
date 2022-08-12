FROM openjdk:11
ADD target/ms1-user-0.0.1-SNAPSHOT.jar ms1-user.jar
ENTRYPOINT ["java","-jar","/ms1-user.jar"]
EXPOSE 9094