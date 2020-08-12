FROM maven:3.6.3-openjdk-8
LABEL maintainer="Louhwz"
ADD target/organization-service-1.0.0.jar /root/
WORKDIR /root
EXPOSE 11402
ENTRYPOINT ["java", "-jar","organization-service-1.0.0.jar"]

