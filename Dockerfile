FROM openjdk:11
COPY . /target/
WORKDIR /target/
EXPOSE 8080
CMD ["java","-jar","./target/viwit-interface-0.0.1-SNAPSHOT.jar"]