## 方法一
docker 启动mysql
```dockerfile
docker run --name mysql -v /home/ljaer/mysql:/var/lib/mysql -p 3307:3307 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
```
进入容器
```dockerfile
docker exec -it 8e7c4d44656d  /bin/bash
```
连接mysql
```mysql
mysql -h localhost -uroot -proot
```

## 方法二 
下载mysql8 安装 运行 