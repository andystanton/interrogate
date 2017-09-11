# Interrogate

A demonstration service built for interrogation by test.

The service is made up of two containers, one wrapping a plain MySQL container and one wrapping a Java application that serves a simple interactive web application.

## Requirements

* Docker

## Usage

Docker Compose is used to trigger a Docker multi-stage build which constructs the Java web app and its Docker image, and then runs this alongside the MySQL container.

```sh
$ docker-compose up
```

The MySQL container is exposed on port 3306 on the host while the web application is exposed on port 8080.
