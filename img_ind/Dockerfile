FROM jenkins/jenkins:lts-alpine

ARG user_of_img=jenkins
ENV USER=$user_of_img

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

USER root

COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY setup.groovy /usr/share/jenkins/ref/init.groovy.d/

RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/plugins.txt \
  && apk add \
  img --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community \
  maven \
  && echo "jenkins:100000:65536" > /etc/subuid \
  && echo "jenkins:100000:65536" > /etc/subgid \
  && mkdir -p /run/runc \
  && chmod 777 /run/runc

USER jenkins
