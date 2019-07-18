package com.lydsexample.weatherkt.utils;

import com.lydsexample.weatherkt.R;
import com.lydsexample.weatherkt.WeatherApp;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/21.
 */

public class AConstants {
    public static final String state = "luoyin";
    public static final long aDayMillisecond = 24 * 60 * 60 * 1000;
    public static final long halfHourMillisecond = 30 * 60 * 1000;
    public static final long aHour = 60 * 60 * 1000;
    public static final String locate_once = "locate_once";//自动定位只会执行一次，如需定位需在城市搜索页面手动点击
    public static final boolean useBDLocate = false;
    public static final String AppTerms = "AppTerms";
    public static final String Resident = "resident";

    public static final String ACTION_SETTINGS_WEATHER_CITY_DATA = "com.ros.action.setting_weather_citydata";
    public static final String ACTION_WEATHER_DOUBLE_CLOCK_STATUS_CHANGE = "com.android.settings.action.DOUBLE_CLOCK_STATUS_CHANGE";
    public static final String ACTION_SETTINGS_WEATHER_DATA = "com.ros.action.setting_weather_data";
    public static final String PERMANENT_CITY_INFO = "permanentCityData";
    public static final String CURRENT_CITY_WEATHER_INFO = "weatherData";

    public static final int token_invalid = 1401;
    public static final int success = 0;
    public static final int no_message = 1801;

    public static final Map<String, String> WEATHER_CODE = new HashMap<>();
    public static final Map<String, String> WIND_DIRECTION = new HashMap<>();
    public static final Map<String, String> WIND_FORCE = new HashMap<>();
    public static final Map<String, String> WIND_SPEED = new HashMap<>();
    public static final Map<String, String> AIR_QUALITY = new HashMap<>();
    public static final Map<String, String> GJ_WARNING_TYPE = new HashMap<>();
    public static final Map<String, String> GJ_WARNING_LEVEL = new HashMap<>();
    public static final Map<String, String> GD_WARNING_TYPE = new HashMap<>();
    public static final Map<String, String> GD_WARNING_LEVEL = new HashMap<>();

    public static final Map<String, Integer> NUMBER_BLACK = new HashMap<>();
    public static final Map<String, Integer> NUMBER_WHITE = new HashMap<>();

    static {
        String[] array = WeatherApp.getInstance().getResources().getStringArray(R.array.weather_code);
        String[] windDirection = WeatherApp.getInstance().getResources().getStringArray(R.array.wind_direction);
        String[] windForce = WeatherApp.getInstance().getResources().getStringArray(R.array.wind_force);
        String[] windSpeed = WeatherApp.getInstance().getResources().getStringArray(R.array.wind_speed);
        String[] airQuality = WeatherApp.getInstance().getResources().getStringArray(R.array.air_quality);
        String[] gjWarningType = WeatherApp.getInstance().getResources().getStringArray(R.array.gj_warning_type);
        String[] gjWarningLevel = WeatherApp.getInstance().getResources().getStringArray(R.array.gj_warning_level);
        String[] gdWarningType = WeatherApp.getInstance().getResources().getStringArray(R.array.gd_warning_type);
        String[] gdWarningLevel = WeatherApp.getInstance().getResources().getStringArray(R.array.gd_warning_level);


        for (int i = 0; i < 33; i++) {
            WEATHER_CODE.put(String.format("%02d", i), array[i]);
        }
        WEATHER_CODE.put("49", array[34]);
        WEATHER_CODE.put("53", array[35]);
        WEATHER_CODE.put("54", array[36]);
        WEATHER_CODE.put("55", array[37]);

        WEATHER_CODE.put("56", array[38]);
        WEATHER_CODE.put("57", array[39]);
        WEATHER_CODE.put("58", array[40]);
        WEATHER_CODE.put("99", array[41]);

        for (int i = 0; i < 10; i++) {
            WIND_DIRECTION.put(String.valueOf(i), windDirection[i]);
            WIND_FORCE.put(String.valueOf(i), windForce[i]);
            WIND_SPEED.put(String.valueOf(i), windSpeed[i]);
        }
        for (int i = 1; i < 7; i++) {
            AIR_QUALITY.put(String.valueOf(i), airQuality[i - 1]);
        }
        for (int i = 1; i < 15; i++) {
            GJ_WARNING_TYPE.put(String.valueOf(i), gjWarningType[i - 1]);
        }
        for (int i = 1; i < 5; i++) {
            GJ_WARNING_LEVEL.put(String.valueOf(i), gjWarningLevel[i - 1]);
        }
        for (int i = 1; i < 12; i++) {
            GD_WARNING_TYPE.put("gd" + String.format("%02d", i), gdWarningType[i - 1]);
        }
        for (int i = 1; i < 7; i++) {
            GD_WARNING_LEVEL.put(String.valueOf(i), gdWarningLevel[i - 1]);
        }
        for (int i = 0; i < 10; i++) {
            NUMBER_BLACK.put(String.valueOf(i), AUtils.getResId(WeatherApp.getInstance(), "ic_number_black_" + i));
        }
        for (int i = 0; i < 10; i++) {
            NUMBER_WHITE.put(String.valueOf(i), AUtils.getResId(WeatherApp.getInstance(), "ic_number_white_" + i));
        }
    }

    public static void reloadConstant() {
        ClassicsHeader.REFRESH_HEADER_REFRESHING = WeatherApp.getInstance().getString(R.string.header_refreshing);//"正在刷新...";
        ClassicsHeader.REFRESH_HEADER_FINISH = WeatherApp.getInstance().getString(R.string.header_finish);//"刷新完成";
        WEATHER_CODE.clear();
        WIND_DIRECTION.clear();
        WIND_FORCE.clear();
        WIND_SPEED.clear();
        AIR_QUALITY.clear();
        GJ_WARNING_TYPE.clear();
        GJ_WARNING_LEVEL.clear();
        GD_WARNING_TYPE.clear();
        GD_WARNING_LEVEL.clear();

        String[] array = WeatherApp.getInstance().getResources().getStringArray(R.array.weather_code);
        String[] windDirection = WeatherApp.getInstance().getResources().getStringArray(R.array.wind_direction);
        String[] windForce = WeatherApp.getInstance().getResources().getStringArray(R.array.wind_force);
        String[] windSpeed = WeatherApp.getInstance().getResources().getStringArray(R.array.wind_speed);
        String[] airQuality = WeatherApp.getInstance().getResources().getStringArray(R.array.air_quality);
        String[] gjWarningType = WeatherApp.getInstance().getResources().getStringArray(R.array.gj_warning_type);
        String[] gjWarningLevel = WeatherApp.getInstance().getResources().getStringArray(R.array.gj_warning_level);
        String[] gdWarningType = WeatherApp.getInstance().getResources().getStringArray(R.array.gd_warning_type);
        String[] gdWarningLevel = WeatherApp.getInstance().getResources().getStringArray(R.array.gd_warning_level);

        for (int i = 0; i < 33; i++) {
            WEATHER_CODE.put(String.format("%02d", i), array[i]);
        }
        WEATHER_CODE.put("49", array[34]);
        WEATHER_CODE.put("53", array[35]);
        WEATHER_CODE.put("54", array[36]);
        WEATHER_CODE.put("55", array[37]);

        WEATHER_CODE.put("56", array[38]);
        WEATHER_CODE.put("57", array[39]);
        WEATHER_CODE.put("58", array[40]);
        WEATHER_CODE.put("99", array[41]);

        for (int i = 0; i < 10; i++) {
            WIND_DIRECTION.put(String.valueOf(i), windDirection[i]);
            WIND_FORCE.put(String.valueOf(i), windForce[i]);
            WIND_SPEED.put(String.valueOf(i), windSpeed[i]);
        }
        for (int i = 1; i < 7; i++) {
            AIR_QUALITY.put(String.valueOf(i), airQuality[i - 1]);
        }
        for (int i = 1; i < 15; i++) {
            GJ_WARNING_TYPE.put(String.valueOf(i), gjWarningType[i - 1]);
        }
        for (int i = 1; i < 5; i++) {
            GJ_WARNING_LEVEL.put(String.valueOf(i), gjWarningLevel[i - 1]);
        }
        for (int i = 1; i < 12; i++) {
            GD_WARNING_TYPE.put("gd" + String.format("%02d", i), gdWarningType[i - 1]);
        }
        for (int i = 1; i < 7; i++) {
            GD_WARNING_LEVEL.put(String.valueOf(i), gdWarningLevel[i - 1]);
        }
    }


}
