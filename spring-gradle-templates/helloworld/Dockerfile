FROM jasonkay/jre11:latest
WORKDIR /app
COPY build/libs/helloworld-1.0.jar helloworldContainer.jar
EXPOSE 8080
CMD ["--rdm.url='http://ito073470.hosts.cloud.ford.com:7980/RTDM/rest/decision/'", "--welcome.value='Hi, I am Robot. Timestamp ms'"]
ENTRYPOINT ["java","-jar","helloworldContainer.jar"]
