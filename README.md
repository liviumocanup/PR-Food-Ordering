# Food Ordering

## Description

Network programming Food Ordering server.

## Create .jar file

```bash
$ mvn clean package
```

## Docker build

```bash
$ docker build . -tag="username"/food-ordering-service:latest
```

## Push image to docker.io

```bash
$ docker push "username"/food-ordering-service
```

## Docker compose to run the Application

```bash
$ docker-compose up --build --remove-orphans
```
