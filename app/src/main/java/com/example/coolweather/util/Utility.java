package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.CoolWeatherDB;
import com.example.coolweather.model.City;
import com.example.coolweather.model.County;
import com.example.coolweather.model.Province;

/**
 * Created by wyf on 2017/2/5.
 */

public class Utility {

    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] allProvinces = response.split(",");
            if(allProvinces != null && allProvinces.length >0)
            {
                for(String p : allProvinces)
                {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceName(array[1]);
                    province.setProvinceCode(array[0]);
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] allCities = response.split(",");
            if(allCities != null && allCities.length >0)
            {
                for(String c : allCities)
                {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityName(array[1]);
                    city.setCityCode(array[0]);
                    city.setProvinceId(provinceId);
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public static  boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityId)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] counties = response.split(",");
            if(counties != null && counties.length >0)
            {
                for(String c : counties)
                {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyName(array[1]);
                    county.setCountyCode(array[0]);
                    county.setCityId(cityId);
                    coolWeatherDB.saveCounty(county);
                }
            }
        }
        return false;
    }
}
