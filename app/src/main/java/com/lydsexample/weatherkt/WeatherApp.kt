package com.lydsexample.weatherkt

import android.app.Application
import android.content.Context
import com.lydsexample.weatherkt.utils.LogUtils
import com.lydsexample.weatherkt.utils.SPUtils
import com.lydsexample.weatherkt.utils.ToastUtils
//import com.scwang.smartrefresh.layout.header.ClassicsHeader

class WeatherApp : Application() {
    companion object {
//        https://www.jianshu.com/p/1fdae52a7d8e
            @JvmStatic
            lateinit var instance: WeatherApp
            private set
    }
//    open lateinit var mAppContext: Context
    val DB_NAME = "weather.db"
//    private var mDaoSession: DaoSession? = null

    var token : String = "";
    var fontScale : Float = 0.0f;
    var isC = true;

    override fun onCreate() {
        super.onCreate()

//        ClassicsHeader.REFRESH_HEADER_PULLING = getString(R.string.header_pulldown) //getString(R.string.header_pulldown);"下拉可以刷新";
//        ClassicsHeader.REFRESH_HEADER_RELEASE = getString(R.string.header_pulldown) //getString(R.string.header_release);//"释放立即刷新";
//        ClassicsHeader.REFRESH_HEADER_REFRESHING = getString(R.string.header_refreshing)//"正在刷新...";
//        ClassicsHeader.REFRESH_HEADER_FINISH = getString(R.string.header_finish)//"刷新完成";
        instance = this
        token = SPUtils.getInstance().getString("access_token", "")
//        token = "dsffffffffffffffffff";
        if (!SPUtils.getInstance().getString("TemperatureUnit", "°C").equals("°C")) {
            isC = false
            //            unitRate = (int) UnitUtils.CtoF(1);
        }
        fontScale = resources.configuration.fontScale

        ToastUtils.setBgResource(R.drawable.toast_bg_shape)
//        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
//        ToastUtils.setBgColor(Color.BLACK);

        try {
            initDB()
        } catch (e: Exception) {
            LogUtils.e("数据库初始化失败，" + e.message, e)
        }

    }

    @Throws(Exception::class)
    fun initDB() {
//        val helper = DaoMaster.DevOpenHelper(this, DB_NAME)
//        val db = helper.getWritableDatabase()
//        val daoMaster = DaoMaster(db)
//        mDaoSession = daoMaster.newSession()
    }



}