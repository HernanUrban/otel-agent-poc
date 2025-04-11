#!/bin/bash

echo "create docker image"
docker build -t hurban/grafana-agent -f Dockerfile .
