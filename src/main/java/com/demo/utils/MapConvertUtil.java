package com.demo.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
*@author: RuanShaoKang
*@date: 2021/7/20
*@description: 地图转换
*/
public class MapConvertUtil {
    public static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    public static double a = 6378245.0;

    /**
    *@author: RuanShaoKang
    *@date: 2021/7/20
    *@description: 高德地图经纬度转换为百度地图
    *@param: [lng, lat]
    *@return: java.lang.Double[]
    */
    public static List<Double> gd2bd(Double lng, Double lat){
        double z = Math.sqrt(lng * lng + lat * lat)+ 0.00002 * Math.sin(lat * x_pi);
        double theta = Math.atan2(lat,lng) + 0.000003 * Math.cos(lng * x_pi);
        double bd_lng = z * Math.cos(theta)+ 0.0065 ;
        double bd_lat = z * Math.sin(theta)+ 0.006 ;
        List<Double> res = new ArrayList<>();
        res.add(bd_lng);
        res.add(bd_lat);
        return res;
    }


}
