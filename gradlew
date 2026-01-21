#!/bin/sh
# Gradle wrapper shell script (minimal version)
DIR="$(cd "$(dirname "$0")" && pwd)"
"$DIR"/gradle/wrapper/gradle-wrapper.jar "$@"
