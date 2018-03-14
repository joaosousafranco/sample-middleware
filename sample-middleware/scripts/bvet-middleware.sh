#!/bin/bash

BASEDIR=$(dirname $0)

APPLICATION=$(ls $BASEDIR | grep fat.jar | tail -n 1)

mkdir -p $BASEDIR/logs

java -jar $BASEDIR/$APPLICATION server $BASEDIR/configuration.json > $BASEDIR/logs/sample-middleware.log
