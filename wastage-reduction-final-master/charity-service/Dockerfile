FROM openjdk:11

ADD ./target/charity-service-0.0.1-SNAPSHOT.jar /usr/src/charity-service-0.0.1-SNAPSHOT.jar

ADD ./src/main/java/com/stackroute/SeedData/CharityList.xlsx /usr/src/CharityList.xlsx

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "charity-service-0.0.1-SNAPSHOT.jar"]
