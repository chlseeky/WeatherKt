package com.lydsexample.weatherkt.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/26.
 */

@Entity
public class City implements Serializable {
    static final long serialVersionUID = 42L;
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String areaId;
    private String nameCn;
    private String nameEn;
    private String fullName;
    private String spell;
    private String districtCn;
    private String districtEn;
    private String provCn;
    private String provEn;
    private String nationCn;
    private String nationEn;
    private String lon;
    private String lat;
    private String timeZone;
    private String foreign;
    private String capCn;

    private int index;//排序定位
    private String wCode;//天气现象编码
    private String tMax;//最高温度
    private String tMin;//最低温度
    private String tCurr;//当前温度
    private String wTime;//天气发布时间
    private boolean isLocate;//是否是定位城市
    private boolean isDel;//最近删除
    private boolean isResident;//常驻城市
    @Generated(hash = 1579111775)
    public City(Long id, @NotNull String areaId, String nameCn, String nameEn,
                String fullName, String spell, String districtCn, String districtEn,
                String provCn, String provEn, String nationCn, String nationEn,
                String lon, String lat, String timeZone, String foreign, String capCn,
                int index, String wCode, String tMax, String tMin, String tCurr,
                String wTime, boolean isLocate, boolean isDel, boolean isResident) {
        this.id = id;
        this.areaId = areaId;
        this.nameCn = nameCn;
        this.nameEn = nameEn;
        this.fullName = fullName;
        this.spell = spell;
        this.districtCn = districtCn;
        this.districtEn = districtEn;
        this.provCn = provCn;
        this.provEn = provEn;
        this.nationCn = nationCn;
        this.nationEn = nationEn;
        this.lon = lon;
        this.lat = lat;
        this.timeZone = timeZone;
        this.foreign = foreign;
        this.capCn = capCn;
        this.index = index;
        this.wCode = wCode;
        this.tMax = tMax;
        this.tMin = tMin;
        this.tCurr = tCurr;
        this.wTime = wTime;
        this.isLocate = isLocate;
        this.isDel = isDel;
        this.isResident = isResident;
    }
    @Generated(hash = 750791287)
    public City() {
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
    public String getNameCn() {
        return this.nameCn;
    }
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
    public String getNameEn() {
        return this.nameEn;
    }
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getFullName() {
        return this.fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getSpell() {
        return this.spell;
    }
    public void setSpell(String spell) {
        this.spell = spell;
    }
    public String getDistrictCn() {
        return this.districtCn;
    }
    public void setDistrictCn(String districtCn) {
        this.districtCn = districtCn;
    }
    public String getDistrictEn() {
        return this.districtEn;
    }
    public void setDistrictEn(String districtEn) {
        this.districtEn = districtEn;
    }
    public String getProvCn() {
        return this.provCn;
    }
    public void setProvCn(String provCn) {
        this.provCn = provCn;
    }
    public String getProvEn() {
        return this.provEn;
    }
    public void setProvEn(String provEn) {
        this.provEn = provEn;
    }
    public String getNationCn() {
        return this.nationCn;
    }
    public void setNationCn(String nationCn) {
        this.nationCn = nationCn;
    }
    public String getNationEn() {
        return this.nationEn;
    }
    public void setNationEn(String nationEn) {
        this.nationEn = nationEn;
    }
    public String getLon() {
        return this.lon;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
    public String getLat() {
        return this.lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getTimeZone() {
        return this.timeZone;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    public String getForeign() {
        return this.foreign;
    }
    public void setForeign(String foreign) {
        this.foreign = foreign;
    }
    public String getCapCn() {
        return this.capCn;
    }
    public void setCapCn(String capCn) {
        this.capCn = capCn;
    }
    public int getIndex() {
        return this.index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getWCode() {
        return this.wCode;
    }
    public void setWCode(String wCode) {
        this.wCode = wCode;
    }
    public String getTMax() {
        return this.tMax;
    }
    public void setTMax(String tMax) {
        this.tMax = tMax;
    }
    public String getTMin() {
        return this.tMin;
    }
    public void setTMin(String tMin) {
        this.tMin = tMin;
    }
    public String getTCurr() {
        return this.tCurr;
    }
    public void setTCurr(String tCurr) {
        this.tCurr = tCurr;
    }
    public String getWTime() {
        return this.wTime;
    }
    public void setWTime(String wTime) {
        this.wTime = wTime;
    }
    public boolean getIsLocate() {
        return this.isLocate;
    }
    public void setIsLocate(boolean isLocate) {
        this.isLocate = isLocate;
    }
    public boolean getIsDel() {
        return this.isDel;
    }
    public void setIsDel(boolean isDel) {
        this.isDel = isDel;
    }
    public boolean getIsResident() {
        return this.isResident;
    }
    public void setIsResident(boolean isResident) {
        this.isResident = isResident;
    }
    
}
