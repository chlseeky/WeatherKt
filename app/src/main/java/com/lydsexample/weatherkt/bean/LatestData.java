package com.lydsexample.weatherkt.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by Administrator on 2018/12/4.
 */
@Entity
public class LatestData {
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String areaId;
    private String hourData;
    private String actualData;
    private String weekData;
    private String warningData;
    @Generated(hash = 1214321456)
    public LatestData(Long id, String areaId, String hourData, String actualData,
                      String weekData, String warningData) {
        this.id = id;
        this.areaId = areaId;
        this.hourData = hourData;
        this.actualData = actualData;
        this.weekData = weekData;
        this.warningData = warningData;
    }
    @Generated(hash = 1678615114)
    public LatestData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAreaId() {
        return this.areaId;
    }
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    public String getHourData() {
        return this.hourData;
    }
    public void setHourData(String hourData) {
        this.hourData = hourData;
    }
    public String getActualData() {
        return this.actualData;
    }
    public void setActualData(String actualData) {
        this.actualData = actualData;
    }
    public String getWeekData() {
        return this.weekData;
    }
    public void setWeekData(String weekData) {
        this.weekData = weekData;
    }
    public String getWarningData() {
        return this.warningData;
    }
    public void setWarningData(String warningData) {
        this.warningData = warningData;
    }

    @Override
    public String toString() {
        return "LatestData{" +
                "id=" + id +
                ", areaId='" + areaId + '\'' +
                ", hourData='" + hourData + '\'' +
                ", actualData='" + actualData + '\'' +
                ", weekData='" + weekData + '\'' +
                ", warningData='" + warningData + '\'' +
                '}';
    }
}
