package com.lydsexample.weatherkt.base

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.lydsexample.weatherkt.R
import com.lydsexample.weatherkt.net.WeatherService
import com.lydsexample.weatherkt.utils.ToastUtils

abstract class BaseFragment : Fragment() {
    var mAct: Activity? = null
    val mView: View? = null
    protected var apiService: WeatherService? = null

    protected val typeWarning = 0
    protected val typeActualWeather = 1
    protected val typeWeekWeather = 2
    protected val typeHourWeather = 3


    @SuppressLint("MissingSuperCall")
    override fun onAttach(activity: Activity?) {
        mAct = activity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        mView = inflater.inflate(setLayoutId(), container, false)
        ButterKnife.bind(this, mView)
        initBase(mView)
        return mView

    }

    protected abstract fun setLayoutId(): Int

    protected abstract fun initBase(view: View)

    fun showNetError(errorCode: Int) {
        when (errorCode) {
            0 ->
                ToastUtils.showShort(R.string.success)
            500 ->
                ToastUtils.showShort(R.string.inner_error)
            1401 ->
                ToastUtils.showShort(R.string.token_invalid)
            1403 ->
                ToastUtils.showShort(R.string.lack_permission)
            1500 ->
                ToastUtils.showShort(R.string.over_time)
            1601 ->
                ToastUtils.showShort(R.string.param_error)
            1801 ->
                ToastUtils.showShort(R.string.no_info);
            1802 ->
                ToastUtils.showShort(R.string.lat_long_error)
        }
    }

//    protected fun getToken(type: Int, areaId: String) {
//        if (!NetworkUtils.isConnected()) {
//            ToastUtils.showLong(R.string.not_net)
//            return
//        }
//
//        val appKey = "4f145906137f4094bb81725ab7bc948e"
//        val secret = "09494995cf13c8c0c222ce9188be73dc"
//        apiService = WeatherApiClient.getAuthClient().create(WeatherService::class.java)
//        val queryMap = HashMap<String, Any>()
//
//        val timestampL = System.currentTimeMillis()
//        val uri = "/oauth2/access_token"
//        val timestampStr = timestampL.toString()
//        queryMap["appKey"] = appKey
//        queryMap["secret"] = secret
//        queryMap["state"] = AConstants.state
//        queryMap["timestamp"] = timestampL
//        queryMap["sign"] = MD5Utils.Md5Encode(uri + appKey + timestampStr)
//        val call = apiService.getToken(queryMap)
//        call.enqueue(object : Callback<RspToken> {
//            override fun onResponse(call: Call<RspToken>, response: Response<RspToken>) {
//                //                Log.e("onResponse", response.toString());
//                if (response.code() == 200) {
//                    val rspToken = response.body()
//                    val token = rspToken!!.getData().getAccess_token()
//                    WeatherApp.token = token
//                    SPUtils.getInstance().put("access_token", token)
//                    SPUtils.getInstance().put("refresh_token", rspToken!!.getData().getRefresh_token())
//                    when (type) {
//                        typeActualWeather -> getActualWeather(areaId)
//                        typeHourWeather -> getHourWeather(areaId)
//                        typeWarning -> getWarning(areaId)
//                        typeWeekWeather -> getWeekWeather(areaId)
//                    }
//                } else {
//                    showNetError(response.code())
//                }
//            }
//
//            override fun onFailure(call: Call<RspToken>, t: Throwable) {
//
//            }
//        })
//    }

    override fun onPause() {
        super.onPause()
        ToastUtils.cancel()
    }

    abstract fun getActualWeather(areaId: String)

    abstract fun getHourWeather(areaId: String)

    abstract fun getWeekWeather(areaId: String)

    abstract fun getWarning(areaId: String)


}