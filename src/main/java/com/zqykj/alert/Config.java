package com.zqykj.alert;

import kafka.server.KafkaConfig;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zqykj on 2017/5/17.
 */
public class Config {

    public static Properties KAFKACONFIG = null;
    private static String configPath = "conf/alert.properties";

    static {
        PropertyConfigurator.configure("conf/log4j.properties");
        KAFKACONFIG = new Properties();
        try {
            KAFKACONFIG.load(new FileReader(configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
