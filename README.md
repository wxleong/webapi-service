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

| API Endpoint              | Method | Description                  |
|---------------------------|--------|------------------------------|
| `/api/v1/ping`            | GET    | Checks the API status        |
| `/api/v1/get/test-data`   | GET    | Retrieves test data          |

# Use the Pre-Built Image from GHCR

```
# Start a container by running the image from GHCR
$ docker run -d --name webapi-service -p 8080:8080 --rm -it ghcr.io/wxleong/webapi-service:latest
```
