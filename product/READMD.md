## How to Run

### First time running mangoDB
* pull mangoDB image 
```
docker pull mongodb/mongodb-community-server
```

### Not first time running mangoDB
## one click
```
./startsh.sh
./stopsh.sh
```

* if permission denied
```
chmod 744 ./startsh.sh 
chmod 744 ./stopsh.sh
```
## More granular
* run in docker and expose map local 27017 port to container 27017
```
docker run -p 27017:27017 --name mongo -d mongodb/mongodb-community-server:latest
```

* Check container running
```
docker ps
docker port mongo
```
* Connect to MongoDb Deployment with mangosh
```
docker exec -it mongo mongosh
```

* stop the container
```
docker stop [container_id]
docker rm [container_id]
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