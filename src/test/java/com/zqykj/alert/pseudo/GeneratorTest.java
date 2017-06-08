package com.zqykj.alert.pseudo;

import com.zqykj.alert.entity.DetectedData;
import org.junit.Test;

/**
 * Created by zqykj on 2017/5/16.
 */
public class GeneratorTest {

    @Test
    public void test_generator_detected() {
        GenerateDetectedData generator = new GenerateDetectedData();
        DetectedData detectedData = generator.generatorObj();
        System.out.println(detectedData);
    }
}
