FROM java:7

ADD ./ /application
VOLUME ["/application/data", "/application/gradle"]
EXPOSE 8080
WORKDIR /application
ENTRYPOINT ["/application/gradlew", "bootRun"]
