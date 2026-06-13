#!/bin/sh

# Find the script directory
SCRIPT_DIR="$( cd "$( dirname "$0" )" && pwd )"

# Find Java
if [ -n "$JAVA_HOME" ] ; then
    JAVA_CMD="$JAVA_HOME/bin/java"
else
    JAVA_CMD="java"
fi

# Run gradle wrapper
exec "$JAVA_CMD" \
    -classpath "$SCRIPT_DIR/gradle/wrapper/gradle-wrapper.jar" \
    org.gradle.wrapper.GradleWrapperMain \
    "$@"
