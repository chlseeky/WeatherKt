package com.lydsexample.weatherkt.utils;

/**
 * Created by Administrator on 2018/12/5.
 */

public class UnitUtils {

    public static double FtoC(double F) {
        double C;
        C = (5.0 / 9) * (F - 32);
        return C;
    }

    public static double CtoF(double C) {
        double F;
        F = (9.0 / 5) * C + 32;
        return F;
    }
}
