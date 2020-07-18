FROM openjdk:11

ADD ./target/restaurant-service-0.0.1-SNAPSHOT.jar /usr/src/restaurant-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "restaurant-service-0.0.1-SNAPSHOT.jar"]

