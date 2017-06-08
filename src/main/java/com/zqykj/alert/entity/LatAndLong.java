package com.zqykj.alert.entity;

/**
 * Created by zqykj on 2017/5/16.
 */
public class LatAndLong {

    /**
     * 纬度
     */
    private String latitude;
    private String longitude;

    public LatAndLong() {
    }

    public LatAndLong(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LatAndLong{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
