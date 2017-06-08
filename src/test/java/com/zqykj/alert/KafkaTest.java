package com.zqykj.alert;

import com.zqykj.alert.kafka.Consumer;
import org.junit.Test;

/**
 * Created by zqykj on 2017/5/16.
 */
public class KafkaTest {

    @Test
    public void test_consumer_topic() {
        Consumer consumer = new Consumer(new String[]{"detected"});
        consumer.consumerData();
    }
}
