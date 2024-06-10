package com.example.weatherproject.viewmodel

import android.location.Location
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherproject.data.WeatherRepository
import com.example.weatherproject.data.model.WeatherData
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.HttpException
import java.io.IOException

class WeatherViewModel:ViewModel() {

    private val _data = mutableStateOf<WeatherData?>(null)

    val data : State<WeatherData?> = _data

   private val repository = WeatherRepository()

    fun fetchWeatherDetails(location: String , key :String = "79ae019809b1af2451d75f57bcba20de"){
        viewModelScope.launch {
            try {
                val getdata = repository.getWeatherDetails(location,key)
                _data.value = getdata
            }
            catch (e : IOException){
                e.printStackTrace()

            }
            catch (e : HttpException){
                e.printStackTrace()
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
    }

}