#!/bin/bash

cd $(dirname "$0")
docker compose -p otel-agent-poc down -v --remove-orphans