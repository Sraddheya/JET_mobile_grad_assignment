package com.example.jet_mobile_grad_assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jet_mobile_grad_assignment.data.models.Restaurant
import com.example.jet_mobile_grad_assignment.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RestaurantViewModel : ViewModel() {

    // MutableLiveData to hold the values the MainActivity will observe
    private val privateRestaurants = MutableLiveData<List<Restaurant>>()
    private val privateError = MutableLiveData<String>()

    // Coroutine to get the restaurant data from the api
    fun getRestaurants() {
        viewModelScope.launch {
            try {
                // Making the API call
                val result = RetrofitInstance.restaurantAPI.getRestaurantResponse()
                if (result.isSuccessful) {
                    privateRestaurants.value = result.body()!!.restaurants
                } else {
                    privateError.value = "Error: ${result.errorBody().toString()}"
                }
            } catch (e: IOException) {
                privateError.postValue("Network Error: ${e.message}")
            } catch (e: HttpException) {
                privateError.postValue("HTTP Error: ${e.message}")
            } catch (e: Exception) {
                privateError.postValue("Unexpected Error: ${e.message}")
            }
        }
    }

    // Public methods to expose the restaurant data to the MainActivity
    fun observeRestaurants(): LiveData<List<Restaurant>> {
        return privateRestaurants
    }

    // Public method to expose the error data to the MainActivity
    fun observeError(): LiveData<String> {
        return privateError
    }

}