package com.zqykj.alert.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by weifeng on 2017/5/23.
 */
public class JsonTest {

    @Test
    public void getKey() {
        JSONObject jsonObject = JSON.parseObject("{\"requestId\": \"964e69bc\",\"fields\": {\"phoneNum\": \"13344333344\",\"personName\": \"李某某\"}}");
        System.out.println(jsonObject);
        Iterator<Map.Entry<String, Object>> iterator = jsonObject.getJSONObject("fields").entrySet().iterator();
        jsonObject.getJSONArray("").getJSONObject(1).keySet();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key=" + entry.getKey() + " , value=" + entry.getValue());
        }
    }
}
