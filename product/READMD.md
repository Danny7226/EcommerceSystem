## How to Run

### First time running mangoDB
* pull mangoDB image 
```
docker pull mongodb/mongodb-community-server
docker run --name mongo -d mongodb/mongodb-community-server:latest
```

### Not first time running mangoDB
* run in docker
```
docker start [container_id]
```

* Check container running
```
docker container ls
```
* Connect to MongoDb Deployment with mangosh
```
docker exec -it mongo mongosh
```

* stop the container
```
docker stop [container_id]
```

### compile the project into a jar file
```
mvn package
```


### Run the project based on the jar file
```
java -jar [compiled_jar_file]
// java -jar target/product-0.0.1-SNAPSHOT.jar
```