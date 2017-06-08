package com.zqykj.alert.pseudo;

import com.zqykj.alert.entity.DetectedData;
import com.zqykj.alert.entity.LatAndLong;

import java.util.Random;
import java.util.UUID;

import static com.zqykj.alert.cache.Cache.*;

/**
 * Created by zqykj on 2017/5/16.
 */
public class GenerateDetectedData {

    private Random random = new Random();
    int uidSize = UIDLIST.size();
    int latSize = LATANDLONGLIST.size();

    public DetectedData generatorObj() {
        DetectedData detectedData = new DetectedData();
        String uid = UIDLIST.get(random.nextInt(uidSize));
        detectedData.setUid(uid);
        detectedData.setElpID("testELP");
        detectedData.setLabel(uid);
        detectedData.setEntity_id(UUID.randomUUID().toString().replaceAll("-", ""));
        int nextInt = random.nextInt(2);
        if (nextInt == 0) {
            detectedData.setEntity_type("testCase2-1");
        } else {
            detectedData.setEntity_type("testCase2-2");
        }

        detectedData.setTimestamp(System.currentTimeMillis());
        LatAndLong latAndLong = LATANDLONGLIST.get(random.nextInt(latSize));
        detectedData.setLatitude(latAndLong.getLatitude());
        detectedData.setLongitude(latAndLong.getLongitude());
        return detectedData;
    }

}
