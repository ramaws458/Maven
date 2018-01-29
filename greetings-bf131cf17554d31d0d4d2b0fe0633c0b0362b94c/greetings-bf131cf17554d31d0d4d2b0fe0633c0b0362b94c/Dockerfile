FROM payara/micro
COPY build/libs/greetings.war /opt/payara/deployments/
CMD java -jar payara-micro.jar --port 8085 --deploymentDir deployments
