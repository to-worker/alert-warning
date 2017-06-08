package com.zqykj.alert.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by fengwei on 17/5/15.
 */
public class Consumer {

    private KafkaConsumer<String, String> consumer = null;
    private String[] topics;

    public Consumer(String[] topics) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "Master:9092,Work01:9092,Work02:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "zqykj-01");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<String, String>(props);
        this.topics = topics;
    }

    public void consumerData() {
        consumer.subscribe(Arrays.asList(topics));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("time=" + record.timestamp() + " ,topic=" + record.topic() +
                        ", offset: " + record.offset() + " , key=" + record.key() + ", value: " + record.value());
            }
        }
    }

}
