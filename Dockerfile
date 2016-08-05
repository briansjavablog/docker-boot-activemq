FROM anapsix/docker-oracle-java8

# Creating working directory
WORKDIR /app

# Add src to working directory
ADD target/docker-boot-activemq-0.1.0.jar /app/docker-boot-activemq-0.1.0.jar

# Start app
ENTRYPOINT ["java","-jar","/app/docker-boot-activemq-0.1.0.jar"]                                                             