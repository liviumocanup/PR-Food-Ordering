FROM openjdk:11
COPY target/food-ordering-service.jar food-ordering-service.jar
EXPOSE ${port}
ENTRYPOINT exec java -jar food-ordering-service.jar