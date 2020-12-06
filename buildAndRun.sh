#!/bin/bash

docker build --rm -t open-weather-forecast .
docker run --rm -p 8080:8080 open-weather-forecast:latest