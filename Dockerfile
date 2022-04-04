FROM java:8
VOLUME /tmp
COPY target/carcontroller-0.0.1-SNAPSHOT.jar carcontroller.jar
RUN bash -c "touch /carcontroller.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","carcontroller.jar"]
