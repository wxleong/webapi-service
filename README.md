# WebAPI Service

# Manually Build The Docker Image

```
# Build the image
$ docker build -t webapi:local -f "./Dockerfile" .

# Start a container by running the image
$ docker run -d -n webapi-service -p 8080:8080 --rm -it webapi:local

# Show the status of running containers
$ docker container ls -la

# Ping the service
$ curl localhost:8080/api/v1/ping

# Stop the container
$ docker container stop webapi-service

# Remove stopped containers
$ docker container prune
```