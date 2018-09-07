# Smart Reads Application

## Running the application

```
mvn clean install
java -jar target/smart-reads-0.0.1-SNAPSHOT.jar
```

## Access the REST API

http://localhost:8080/api/smart/reads/{account_number}

Current test data allows for account_number to be 10001 or 10002

## Access the H2 database

http://localhost:8080/h2-console/

Make sure `JDBC_URL` = `dbc:h2:mem:testdb`
