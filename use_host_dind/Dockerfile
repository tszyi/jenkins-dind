FROM jenkins/jenkins:lts

ARG DOCKER_GID

USER root

COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY daemon.json /etc/docker/
COPY setup_admin.groovy /usr/share/jenkins/ref/init.groovy.d/

RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/plugins.txt \
  && chmod ugo+rwx /etc/docker/daemon.json \
  && chown -R 1000:1000 /etc/docker/daemon.json \
  && curl -sSL https://get.docker.com/ | sh \
  && apt-get -q autoremove \
  && apt-get -q clean -y \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/*.bin \
  && groupadd -g ${DOCKER_GID:-994} docker \
  && usermod -aG docker jenkins

USER jenkins
