#!/bin/bash

cd $(dirname "$0")
docker compose -p otel-agent-poc up -d --build --remove-orphans