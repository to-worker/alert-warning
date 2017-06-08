package com.zqykj.alert.etl;

import org.junit.Test;

/**
 * Created by zqykj on 2017/5/16.
 */
public class EtractTest {

    @Test
    public void test_load_file() {
        String filePath = "E:\\zqy\\预警设计\\样例数据\\sz.txt";
        String outputPath = "E:\\zqy\\预警设计\\样例数据\\latitudeAndlongitude.txt";
        String separator = "\t";
        EtractLatitude etractLatitude = new EtractLatitude(filePath, outputPath, separator);
        etractLatitude.loadFile();
    }
}
