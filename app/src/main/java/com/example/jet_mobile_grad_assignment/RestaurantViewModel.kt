package com.example.jet_mobile_grad_assignment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jet_mobile_grad_assignment.data.models.Restaurant
import com.example.jet_mobile_grad_assignment.network.RetrofitInstance
import com.example.jet_mobile_grad_assignment.ui.TAG
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants.asStateFlow()

    private val privateError = MutableLiveData<String>()

    // Coroutine to get the restaurant data from the api
    fun getRestaurants( postcode: String) {
        viewModelScope.launch {
            try {
                // Making the API call
                val result = repository.getRestaurantsByPostcode(postcode)
                if (result.isSuccessful) {
                    _restaurants.value = (result.body()?.restaurants?.take(10) ?: emptyList())
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

}