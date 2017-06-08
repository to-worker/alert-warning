package com.zqykj.alert.cache;

import com.zqykj.alert.entity.LatAndLong;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by zqykj on 2017/5/16.
 */
public class CacheTest {

    @Test
    public void test_cache_latitude() {
        List<LatAndLong> latandlonGlIST = Cache.LATANDLONGLIST;
        List<String> uidList = Cache.UIDLIST;

        System.out.println(uidList.size());
        System.out.println(uidList.get(0));
        System.out.println(latandlonGlIST.size());
        System.out.println(latandlonGlIST.get(0));
    }

    @Test
    public void pseudo_uids() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("E:\\zqy\\预警设计\\样例数据\\uids.txt"));
        for (int i = 0; i < 10000; i++) {
            String uid = UUID.randomUUID().toString().replaceAll("-", "");
            bufferedWriter.write(uid);
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();

    }

}
