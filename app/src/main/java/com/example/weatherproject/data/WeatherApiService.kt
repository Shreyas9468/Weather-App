package com.example.weatherproject.data

import com.example.weatherproject.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("data/2.5/weather")
    suspend fun getWeatherDetails(

        @Query("q") location: String,
        @Query("appid") key: String

    ):WeatherData
}

//https://api.openweathermap.org/data/2.5/weather?q=Mumbai&APPID=79ae019809b1af2451d75f57bcba20de