package com.lydsexample.weatherkt.utils;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.lydsexample.weatherkt.WeatherApp;

import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2018/12/5.
 */

public class AUtils {
    public static int SWITCH_TYPE_ON = 1;

    public static int getResId(Context context, String name) {
        Resources r = context.getResources();
        switch (name) {
            case "00":
                break;
        }
        int id = r.getIdentifier(name, "drawable", context.getPackageName());
        return id;
    }

    /**
     * 获取系统设置项
     * @param contentResolver ContentResolver
     * @param key Key
     * @return
     */
    public static String getSystemString(ContentResolver contentResolver, String key){
        return  getSystemString(contentResolver,key,null);
    }

    /**
     * 获取系统设置项
     * @param contentResolver ContentResolver
     * @param key Key
     * @param defaultValue 默认值
     * @return
     */
    public static String getSystemString(ContentResolver contentResolver, String key, String defaultValue){
        String result = android.provider.Settings.System.getString(contentResolver,key);
        if(TextUtils.isEmpty(result)){
            result = defaultValue;
        }
        return  result;
    }

    /**
     * module TW_FWK_SETTINGS
     * author ccliu
     * date 2018/10/26 17:26
     * description openOrCloseType
     * 获取本地保存的状态开关
     */
    public static boolean getOpenOrCloseType(ContentResolver contentResolver, String key, boolean defaultValue){
        String tempType = getSystemString(contentResolver, key);
        if (!TextUtils.isEmpty(tempType)) {
            int tempInt = 0;
            try {
                tempInt = Integer.parseInt(tempType);
            } catch (Exception e) {
                Log.e("getOpenOrCloseType","getOpenOrCloseType param is not integer");
                return defaultValue;
            }
            return tempInt == SWITCH_TYPE_ON;
        }
        return defaultValue;
    }

    /**
     * module TW_FWK_SETTINGS
     * author ccliu
     * date 2018/10/26 17:26
     * description getOpenOrCloseType 获取本地保存的状态开关
     */
    public static boolean getOpenOrCloseType(ContentResolver contentResolver, String key){
        return getOpenOrCloseType(contentResolver,key,false);
    }

//    public static void saveSetting(String cityName, String temperature, String weatherCode) {
////        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////            if (!Settings.System.canWrite(context)) {
////                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
////                intent.setData(Uri.parse("package:" + context.getPackageName()));
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(intent);
////            } else {
////            }
////        }
//        if (!TextUtils.isEmpty(cityName) && !TextUtils.isEmpty(temperature) && !TextUtils.isEmpty(weatherCode)) {
//            try {
//                Settings.Global.putString(WeatherApp.getInstance().getContentResolver(), "weatherData", cityName + ";" + temperature + ";" + weatherCode);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
////            Settings.Secure.putString(WeatherApp.getInstance().getContentResolver(), "weatherData", cityName+";"+temperature+";"+weatherCode);
////            Settings.System.putString(WeatherApp.getInstance().getContentResolver(), "weatherData", cityName+";"+temperature+";"+weatherCode);
//        }
//    }

//    public static void setWeatherInfo(String key, String weatherInfo) {
//        Settings.Global.putString(context.getContentResolver(), key, weatherInfo);
//    }

//    public static void setPermanentCityData(String key,String permanentCityData) {
//        Settings.Global.putString(context.getContentResolver(), "permanentCityData", permanentCityData);
//    }

    public static boolean saveSetting(String cityName, String temperature, String weatherCode) {
        if (!TextUtils.isEmpty(cityName) && !TextUtils.isEmpty(temperature) && !TextUtils.isEmpty(weatherCode)) {
            String weatherInfo = cityName + ";" + temperature + ";" + weatherCode;
//            LogUtils.e(weatherInfo);
            Intent intent = new Intent();
            intent.putExtra(AConstants.CURRENT_CITY_WEATHER_INFO, weatherInfo);
            intent.setAction(AConstants.ACTION_SETTINGS_WEATHER_DATA);
            WeatherApp.getInstance().sendBroadcast(intent);

//            try {
//                ReflectUtils utils = ReflectUtils.reflect("android.app.RosServiceManager");
//                utils.method("setWeatherInfo", "weatherData", weatherInfo);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

//            LogUtils.e(a);

//            Class clz = null;
//            Method method = null;
//            Constructor constructor = null;
//            boolean isSetSuccess = false;
//            try {
//                clz = Class.forName("android.app.RosServiceManager");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            try {
//                method = clz.getDeclaredMethod("setWeatherInfo", String.class, String.class);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                try {
//                    constructor = (Constructor) clz.getDeclaredConstructor();
//                    try {
//                        isSetSuccess = (Boolean) method.invoke(constructor.newInstance(),"weatherData", weatherInfo);
//                        return isSetSuccess;
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                }}
//            catch (Exception e){
//                e.printStackTrace();
//            }
//            return isSetSuccess;
        }
        return false;
    }

    /**
     * 城市搜索接口不返回经纬度，数据不做判空，城市删除时清空数据
     * @param cityNameCn
     * @param cityNameEn
     * @param longitude
     * @param latitude
     */
    public static void savePermanentCityData(String cityNameCn, String cityNameEn, String longitude, String latitude) {
//        if (!TextUtils.isEmpty(cityName) && !TextUtils.isEmpty(longitude) && !TextUtils.isEmpty(latitude)) {
//        if (!TextUtils.isEmpty(cityName)) {
            String permanent = cityNameCn + ";" + longitude + ";" + latitude + ";" + cityNameEn;
//            LogUtils.e(permanent);
            Intent intent = new Intent();
            intent.putExtra(AConstants.PERMANENT_CITY_INFO, permanent);
            intent.setAction(AConstants.ACTION_SETTINGS_WEATHER_CITY_DATA);
            WeatherApp.getInstance().sendBroadcast(intent);
//            try {
//                ReflectUtils utils = ReflectUtils.reflect("android.app.RosServiceManager");
//                utils.method("setWeatherInfo", "permanentCityData", permanent);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void saveResidentCity() {
        SPUtils.getInstance("weather_data", Context.MODE_WORLD_READABLE).put("weather_focus", "");
    }

    public static int getTemperature(int c) {
        if (WeatherApp.getInstance().isC()) {
            return c;
        } else {
            BigDecimal bg = new BigDecimal(UnitUtils.CtoF(c));
            return bg.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
        }
    }

    public static boolean isZh(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if (language.endsWith("zh"))
            return true;
        else
            return false;
    }

    public static int getWindLevel(float wind) {
        if (wind >= 0 && wind <= 0.2) {
            return 0;
        } else if (wind >= 0.3 && wind <= 1.5) {
            return 1;
        } else if (wind >= 1.6 && wind <= 3.3) {
            return 2;
        } else if (wind >= 3.4 && wind <= 5.4) {
            return 3;
        } else if (wind >= 5.5 && wind <= 7.9) {
            return 4;
        } else if (wind >= 8.0 && wind <= 10.7) {
            return 5;
        } else if (wind >= 10.8 && wind <= 13.8) {
            return 6;
        } else if (wind >= 13.9 && wind <= 17.1) {
            return 7;
        } else if (wind >= 17.2 && wind <= 20.7) {
            return 8;
        } else if (wind >= 20.8 && wind <= 24.4) {
            return 9;
        } else if (wind >= 24.5 && wind <= 28.4) {
            return 10;
        } else if (wind >= 28.5 && wind <= 32.6) {
            return 11;
        } else if (wind >= 32.7 && wind <= 36.9) {
            return 12;
        } else if (wind >= 37.0 && wind <= 41.4) {
            return 13;
        } else if (wind >= 41.5 && wind <= 46.1) {
            return 14;
        } else if (wind >= 46.2 && wind <= 50.9) {
            return 15;
        } else if (wind >= 51.0 && wind <= 56.0) {
            return 16;
        } else if (wind >= 56.1) {
            return 17;
        } else {
            return 0;
        }
    }

    public static String mergerCode(String code) {
//        StringBuffer returnCode = new StringBuffer("normal_");
//        StringBuffer returnCode = new StringBuffer("large_");
//        StringBuffer returnCode = new StringBuffer("small_");
        StringBuffer returnCode = new StringBuffer("");
        if (TextUtils.isEmpty(code)) {
            return returnCode.append("00").toString();
        }
        switch (code) {
            //晴
            case "00":
                returnCode.append("00");
                break;
            //多云
            case "01":
            case "02":
                returnCode.append("01");
                break;
            //阴
//            case "02":
//                returnCode = "02";
//                break;
            //雨
            case "03":
            case "04":
            case "05":
            case "06":
            case "07":
            case "08":
            case "09":
            case "10":
            case "11":
            case "12":
            case "19":
            case "21":
            case "22":
            case "23":
            case "24":
            case "25":
                returnCode.append("08");
                break;
            //雪
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "33":
            case "26":
            case "27":
            case "28":
                returnCode.append("28");
                break;
            //雾
            case "57":
            case "58":
            case "49":
            case "32":
            case "18":
                returnCode.append("18");
                break;
            //霾
            case "53":
            case "54":
            case "55":
            case "56":
                returnCode.append("53");
                break;
            //沙尘
            case "20":
            case "29":
            case "30":
            case "31":
                returnCode.append("20");
                break;
            default:
                returnCode.append("00");
                break;
        }
        return returnCode.toString();
    }


    public static String mergerCodeBig(String code) {
        final String Y_SCREEN_MODE = "y_screen_mode";
        final int SCREEN_MODE_MAX = 0;
        final int SCREEN_MODE_MIN = 1;
        int mScreenMode = android.provider.Settings.System.getInt(WeatherApp.getInstance().getContentResolver(), Y_SCREEN_MODE, SCREEN_MODE_MAX);
        StringBuffer returnCode;
        if (mScreenMode == SCREEN_MODE_MAX) {
            if (ScreenUtils.isLandscape()) {
                returnCode = new StringBuffer("large_");
            }else{
                returnCode = new StringBuffer("normal_");
            }
        }else{
            returnCode = new StringBuffer("small_");
        }

        if (TextUtils.isEmpty(code)) {
            return returnCode.append("00").toString();
        }
        switch (code) {
            //晴
            case "00":
                returnCode.append("00");
                break;
            //多云
            case "01":
            case "02":
                returnCode.append("01");
                break;
            //阴
//            case "02":
//                returnCode = "02";
//                break;
            //雨
            case "03":
            case "04":
            case "05":
            case "06":
            case "07":
            case "08":
            case "09":
            case "10":
            case "11":
            case "12":
            case "19":
            case "21":
            case "22":
            case "23":
            case "24":
            case "25":
                returnCode.append("08");
                break;
            //雪
            case "13":
            case "14":
            case "15":
            case "16":
            case "17":
            case "33":
            case "26":
            case "27":
            case "28":
                returnCode.append("28");
                break;
            //雾
            case "57":
            case "58":
            case "49":
            case "32":
            case "18":
                returnCode.append("18");
                break;
            //霾
            case "53":
            case "54":
            case "55":
            case "56":
                returnCode.append("53");
                break;
            //沙尘
            case "20":
            case "29":
            case "30":
            case "31":
                returnCode.append("20");
                break;
            default:
                returnCode.append("00");
                break;
        }
        return returnCode.toString();
    }

    public static String getAirQuality(String qualityValue) {
        int value = Integer.parseInt(qualityValue);
        if (value <= 50) {
            return AConstants.AIR_QUALITY.get("1");
        } else if (value > 50 && value <= 100) {
            return AConstants.AIR_QUALITY.get("2");
        } else if (value > 100 && value <= 200) {
            return AConstants.AIR_QUALITY.get("3");
        } else if (value > 200 && value <= 300) {
            return AConstants.AIR_QUALITY.get("4");
        } else if (value > 300 && value <= 500) {
            return AConstants.AIR_QUALITY.get("5");
        } else if (value > 500) {
            return AConstants.AIR_QUALITY.get("6");
        } else {
            return AConstants.AIR_QUALITY.get("1");
        }
    }

    public static String getVisibility(Context context, String visibility) {
        try {
            if (TextUtils.isEmpty(visibility)) {
                return "--";
            }

            int vis = Integer.parseInt(visibility);
            if (vis < 1000) {
                return visibility + "M";
            } else {
                float km = vis * 1.0f / 1000;
                NumberFormat nf = NumberFormat.getNumberInstance();
                nf.setMaximumFractionDigits(1);
                return nf.format(km) + "KM";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "--";
    }

    private void test() {
        BigDecimal bg = new BigDecimal(123f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        DecimalFormat df = new DecimalFormat("#.00");
        String f2 = df.format(123f);

        String f3 = String.format("%.1f", 123f);

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(1);
        String f4 = nf.format(123.4345f);

//        Log.e("test", f1 + " " + f2 + " " + f3 + " " + f4);
    }

    private void getNetTime() {
        URL url = null;//取得资源对象
        try {
            url = new URL("http://www.baidu.com");
            //url = new URL("http://www.ntsc.ac.cn");//中国科学院国家授时中心
            URLConnection uc = url.openConnection();//生成连接对象
            uc.connect(); //发出连接
            long ld = uc.getDate(); //取得网站日期时间
            DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日\n\nHH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(ld);
            final String format = formatter.format(calendar.getTime());
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    LogUtils.e(format);
////                    tv_time.setText(format);
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断某个服务是否正在运行的方法
     *
     * @param serviceName 是包名+服务的类名（例如：net.loonggg.testbackstage.TestService）
     * boolean messageServiceALive = serviceAlive(WeatherUpdateService.class.getName());
     * @return true代表正在运行，false代表服务没有正在运行
     */
    private boolean serviceAlive(String serviceName, Context context) {
        boolean isWork = false;
        ActivityManager myAM = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> myList = myAM.getRunningServices(100);
        if (myList.size() <= 0) {
            return false;
        }
        for (int i = 0; i < myList.size(); i++) {
            String mName = myList.get(i).service.getClassName().toString();
            if (mName.equals(serviceName)) {
                isWork = true;
                break;
            }
        }
        return isWork;
    }

}
