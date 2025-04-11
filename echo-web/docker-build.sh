#!/bin/bash
echo "build..."
./mvnw clean package
if [ $? -ne 0 ]
then
    echo failed
else
    echo "create docker image"
    docker build -t hurban/echo-web -f Dockerfile .
fi

