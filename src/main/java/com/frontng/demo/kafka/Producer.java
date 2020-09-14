package com.frontng.demo.kafka;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * 生产者端
 */
public class Producer {

    /**
     * 定义主题
     */
    public static String TOPIC = "frontng_test";

    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        //kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(p);

        try {
            while (true) {
                String msg = "Hello," + new Random().nextInt(100);
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, msg);
                kafkaProducer.send(record);
                System.out.println("msg sent:" + msg);
                Thread.sleep(500);
            }
        } finally {
            kafkaProducer.close();
        }

    }
}