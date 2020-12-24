FROM jenkins/jenkins:lts

COPY docker /usr/local/bin

ARG DOCKER_GID

USER root

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/plugins.txt

COPY setup_admin.groovy /usr/share/jenkins/ref/init.groovy.d/

RUN apt-get update \
  && apt-get install -y maven \
  && apt-get clean \
  && rm -rf /var/cache/apt/lists \
  && rm -rf /var/lib/apt/lists/*

RUN groupadd -g ${DOCKER_GID:-994} docker \
  && usermod -aG docker jenkins

USER jenkins

