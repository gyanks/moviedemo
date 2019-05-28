FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=userdb
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/userdb
ENV MYSQL_USER=app_root
ENV MYSQL_PASSWORD=root123
ADD ./target/authenticationservice-0.0.1-SNAPSHOT.jar /usr/src/authenticationservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","authenticationservice-0.0.1-SNAPSHOT.jar"]
