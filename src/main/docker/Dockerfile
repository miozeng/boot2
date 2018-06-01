FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD boot2.jar boot2.jar
RUN sh -c 'touch /boot2.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /boot2.jar" ]