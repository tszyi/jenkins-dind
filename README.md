# Jenkins dind

## 說明

因為我想在 Jenkins 容器裡執行 Docker 建置映像檔的功能，才催生出本專案。參考網路上前人奮鬥過的痕跡，做出了 dind（Docker in Docker）的 Jenkins 映像檔。

本專案裡的三個目錄裡的映像檔都有

- 預設帳密皆為 admin 的 Jenkins 使用者
- 預安裝 Jenkins 外掛
- 跳過 setup wizard
- 已安裝 Maven

唯 Docker 的部分略有不同。

### `dind`

將 Docker 安裝在 Jenkins 容器裡，映像檔肥大，超過 1 GB。

### `dind_host`

將 Docker 安裝在 Jenkins 容器裡，但對接的 Docker server（或說 Docker daemon）使用的是主機的，映像檔依舊肥大，超過 1 GB。

### `img_ind`

*經 [Till](https://github.com/till0061) 大神的指點，若僅用到建置映像檔的功能，其實可以不用裝 Docker。*

因此本目錄**安裝了 [img](https://github.com/genuinetools/img)** 的 Jenkins，映像檔大小約 583 MB。

## 參考

參考連結太多了，之後有時間再補上...
