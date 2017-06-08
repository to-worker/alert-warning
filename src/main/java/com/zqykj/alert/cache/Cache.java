package com.zqykj.alert.cache;

import com.zqykj.alert.entity.LatAndLong;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zqykj on 2017/5/16.
 */
public class Cache {


    public static final String INPUTFILE = "data/latitudeAndlongitude.txt";
    public static final String INPUTUIDS = "data/uids.txt";
    public static List<LatAndLong> LATANDLONGLIST = null;
    public static List<String> UIDLIST = null;


    static {
        loadLatitudeAndLongtitude();
        loadUids();
    }

    private static void loadUids() {
        UIDLIST = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(INPUTUIDS));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                UIDLIST.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void loadLatitudeAndLongtitude() {
        LATANDLONGLIST = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(INPUTFILE));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("\t");
                LatAndLong latAndLong = new LatAndLong(arr[0], arr[1]);
                LATANDLONGLIST.add(latAndLong);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
