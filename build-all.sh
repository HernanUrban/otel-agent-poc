#!/bin/bash
guard () {
    local what=$1
    shift
    if "$@"; then
        echo "$what succeeded" >&2
    else
        rc=$?
        echo "$what failed" >&2
        exit $rc
    fi
}

BASEDIR="$( cd "$( dirname "$0" )" && pwd )"

echo "-= echo-web =-"
cd echo-web
guard "echo-web build and docker image" ./docker-build.sh
cd ${BASEDIR}
echo "-= grafana-agent =- "
cd grafana-agent/
guard "service-discovery build and docker image" ./docker-build.sh $1
cd ${BASEDIR}

echo "All projects have been built and images have been created successfully!"