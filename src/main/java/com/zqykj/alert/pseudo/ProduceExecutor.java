package com.zqykj.alert.pseudo;

import com.zqykj.alert.kafka.Producer;
import kafka.server.KafkaConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.zqykj.alert.Config.*;

/**
 * Created by zqykj on 2017/5/16.
 */
public class ProduceExecutor {

    public static void main(String[] args) {

        String topic = KAFKACONFIG.getProperty("kafka.producer.topic");
        String brokesAddress = KAFKACONFIG.getProperty("bootstrap.servers", "Master:9092,Work01:9092,Work03:9092");
        Integer threadNum = Integer.valueOf(KAFKACONFIG.getProperty("producer.thread.num", "1"));
        Long mills = Long.valueOf(KAFKACONFIG.getProperty("producer.time.interval.millis", "0"));
        Integer nanos = Integer.valueOf(KAFKACONFIG.getProperty("producer.time.interval.nanos", "0"));
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {
            exec.execute(new Producer(topic, mills, nanos, brokesAddress));
        }
    }
}
