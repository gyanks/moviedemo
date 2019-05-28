FROM java:8-jre
WORKDIR usr/src
ENV MONGO_DATABASENAME=moviedb
ENV MONGO_URL=mongodb://localhost:27017/moviedb
ADD ./target/movieservice-0.0.1-SNAPSHOT.jar /usr/src/movieservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movieservice-0.0.1-SNAPSHOT"]
