FROM openjdk:11-jdk-stretch

ADD /target/routing-service-0.0.1-SNAPSHOT.jar /usr/src/routing-service-0.0.1-SNAPSHOT.jar

ADD /src/main/java/com/stackroute/seedData/foodavailabilityseed.xlsx /usr/src/foodavailabilityseed.xlsx

WORKDIR /usr/src

ENTRYPOINT ["java","-jar","routing-service-0.0.1-SNAPSHOT.jar"]
