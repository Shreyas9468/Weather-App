package com.example.weatherproject.data

import com.example.weatherproject.data.model.WeatherData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    private val weatherApiService: WeatherApiService

    val BASE_URL = "https://api.openweathermap.org/"

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        weatherApiService = retrofit.create(WeatherApiService ::class.java)
    }

    suspend fun getWeatherDetails(location : String , key : String) : WeatherData{
        return weatherApiService.getWeatherDetails(location,key)
    }


}