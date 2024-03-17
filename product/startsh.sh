#!/bin/zsh
docker run -p 27017:27017 --name mongo -d mongodb/mongodb-community-server:latest
echo "docker container named mongo started"
docker ps
docker port mongo
echo "starting Spring boot project"
mvn package
java -jar target/product-0.0.1-SNAPSHOT.jar