#!/bin/bash

echo "Performing a clean Maven build"
./mvnw clean package -DskipTests=true

echo "Setting the default builder for pack"
pack set-default-builder cloudfoundry/cnb:bionic

echo "Packing VIDEO-SERVICE"
cd video-service
./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
cd ..

echo "Packing SHARING-SERVICE"
cd sharing-service
./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
cd ..

echo "Packing SERVICE-REGISTRY"
cd service-registry
./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
cd ..

echo "Packing API-GATEWAY"
cd api-gateway
./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
cd ..