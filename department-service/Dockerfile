FROM maven:3.6.3-openjdk-8
LABEL maintainer="Louhwz"
ADD target/department-service-1.0.0.jar /root/
WORKDIR /root
ENTRYPOINT ["java", "-jar", "department-service-1.0.0.jar"]
EXPOSE 11401

