# 說明

1. 獲取本機的docker GID並注入到建置映像檔過程
	```shell
	docker build --build-arg DOCKER_GID=$(getent group docker|cut -d : -f 3) -t jenkins:aors .
	```
2. 修改`docker-compose.yaml`的掛載目錄，在本機創建好jenkins_home，這是方便移轉Jenkins資料用的目錄，並且將本機的.m2拷貝一份放進該目錄裡面以讓Jenkins容器可以利用。
	```yaml
	- /home/icsc/tmp/jenkins_home:/var/jenkins_home
	```
3. 運行`docker-compose up -d`
