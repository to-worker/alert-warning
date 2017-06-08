package com.zqykj.alert.kafka;

import com.zqykj.alert.pseudo.GenerateDetectedData;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by fengwei on 17/5/15.
 */
public class Producer implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(Producer.class);

    private KafkaProducer<String, String> producer = null;
    private String topic;
    long millis;
    int nanos;

    GenerateDetectedData generator = new GenerateDetectedData();

    public Producer(String topic, long millis, int nanos, String brokersAddress) {
        Properties props = new Properties();
        props.put("bootstrap.servers", brokersAddress);
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(props);
        this.topic = topic;
        this.millis = millis;
        this.nanos = nanos;
    }

    public void send(String value) {
        logger.debug(value);
        final ProducerRecord<String, String> record = new ProducerRecord<String, String>(
                this.topic, value);
        producer.send(record, new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception e) {
                logger.debug("success...");
            }
        });
    }

    @Override
    public void run() {
        while (true) {
            send(generator.generatorObj().toString());
            try {
                Thread.sleep(this.millis, this.nanos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
