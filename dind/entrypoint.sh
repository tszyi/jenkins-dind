#!/bin/bash
sudo /etc/init.d/docker start && /sbin/tini -- /usr/local/bin/jenkins.sh
