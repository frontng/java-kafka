# Java使用kafka实现发布与订阅


### 1.安装kafka
````
docker pull wurstmeister/zookeeper
docker pull wurstmeister/kafka
````
````
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
docker run -d --name kafka --publish 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=192.168.4.111 --env KAFKA_ADVERTISED_PORT=9092 wurstmeister/kafka:latest
````

### 2.编译
````
cd java-kafka
mvn install
````

### 3.启动订阅程序(start_consumer)
````
mvn exec:java -Dexec.mainClass="com.frontng.demo.kafka.Consumer"
````

### 4.启动发布程序(start_producer)
````
mvn exec:java -Dexec.mainClass="com.frontng.demo.kafka.Producer"
````