FROM jenkins/jenkins:lts

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
#ENV JENKINS_OPTS --argumentsRealm.passwd.admin=admin --argumentsRealm.roles.user=admin --argumentsRealm.roles.admin=admin

VOLUME /home/jenkins/.m2

ARG DOCKER_GID=994

USER root

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

RUN groupadd -g ${DOCKER_GID} docker \
  && curl -sSL https://get.docker.com/ | sh \
  && apt-get -q autoremove \
  && apt-get -q clean -y \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/*.bin \
  && usermod -aG docker jenkins

USER jenkins

