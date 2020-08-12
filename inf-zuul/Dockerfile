FROM maven:3.6.3-openjdk-8
LABEL maintainer="Louhwz"
ADD target/inf-zuul-1.0.0.jar /root/
WORKDIR /root
EXPOSE 11300
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod","inf-zuul-1.0.0.jar"]

