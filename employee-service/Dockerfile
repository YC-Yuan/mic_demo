FROM maven:3.6.3-openjdk-8
LABEL maintainer="Louhwz"
ADD target/employee-service-1.0.0.jar /root/
WORKDIR /root
EXPOSE 11400
ENTRYPOINT ["java", "-jar","employee-service-1.0.0.jar"]

