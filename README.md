# WebAPI Service

# Build Your Own Docker Image

```
# Build the image
$ docker build -t webapi:local -f "./Dockerfile" .

# Start a container by running the image
$ docker run -d --name webapi-service -p 8080:8080 --rm -it webapi:local

# Show the status of running containers
$ docker container ls -la

# Ping the service
$ curl localhost:8080/api/v1/ping

# Stop the container
$ docker container stop webapi-service

# Remove stopped containers
$ docker container prune
```

# APIs Table

| API Endpoint | Method | Description |
|--------------|--------|-------------|
| `/h2-console`             | GET    | H2 in-memory database console. Login information, `Saved Settings: Generic H2 (Embedded)`, `user: admin`, `password: wokeadmin123`, `Driver Class: org.h2.Driver`, `JDBC URL: jdbc:h2:mem:testdb` |
| `/api-docs`               | GET    | SpringDoc OpenAPI |
| `/swagger-ui`             | GET    | SpringDoc OpenAPI with Swagger UI |
| `/api/v1/ping`            | GET    | Checks the API status |
| `/api/v1/get/test-data`   | GET    | Retrieves test data |
| `/api/v1/get/test-data/search/contain?title=xxx` | GET | Queries the test data |

# Use the Pre-Built Image from GHCR

```
# If you have downloaded the image before, remove it first
$ docker images
$ docker rmi --force ghcr.io/wxleong/webapi-service

# Start a container by running the image from GHCR
$ docker run -d --name webapi-service -p 8080:8080 --rm -it ghcr.io/wxleong/webapi-service:latest
$ docker container prune
```
