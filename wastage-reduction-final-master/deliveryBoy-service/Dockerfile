FROM openjdk:11

ADD ./target/deliveryBoy-service-0.0.1-SNAPSHOT.jar /usr/src/deliveryBoy-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "deliveryBoy-service-0.0.1-SNAPSHOT.jar"]

