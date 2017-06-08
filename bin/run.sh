#!/bin/sh

ROOT_DIR="$(dirname $(cd $(dirname $0); pwd))"
echo $ROOT_DIR

java -cp "$ROOT_DIR/alert-warning-1.0-SNAPSHOT.jar" com.zqykj.alert.pseudo.ProduceExecutor
