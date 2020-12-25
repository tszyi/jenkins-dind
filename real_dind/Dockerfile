FROM jenkins/jenkins:lts

USER root

COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY entrypoint.sh .
COPY daemon.json /etc/docker/
COPY setup_admin.groovy /usr/share/jenkins/ref/init.groovy.d/

RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/plugins.txt \
  && chmod ugo+rwx /entrypoint.sh \
  && chmod ugo+rwx /etc/docker/daemon.json \
  && chown -R 1000:1000 /etc/docker/daemon.json \
  && apt-get update \
  && apt-get install -y apt-transport-https \
  ca-certificates \
  gnupg-agent \
  software-properties-common \
  maven \
  sudo \
  && curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add - \
  && apt-key fingerprint 0EBFCD88 \
  && add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" \
  && apt-get update \
  && apt-get install -y docker-ce \
  docker-ce-cli \
  containerd.io \
  && usermod -aG docker jenkins \
  && apt-get clean \
  && rm -rf /var/cache/apt/lists \
  && rm -rf /var/lib/apt/lists/* \
  && echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

USER jenkins

ENTRYPOINT ["/entrypoint.sh"]