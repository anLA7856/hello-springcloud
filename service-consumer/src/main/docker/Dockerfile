FROM java:8
VOLUME /tmp/docker
RUN mkdir /app
COPY service-consumer-1.0-SNAPSHOT.jar /app/app.jar
COPY runboot.sh /app/
RUN bash -c 'touch /app/app.jar'
WORKDIR /app
RUN chmod a+x runboot.sh
EXPOSE 8761
CMD /app/runboot.sh