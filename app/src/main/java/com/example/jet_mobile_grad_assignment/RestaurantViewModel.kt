package com.example.jet_mobile_grad_assignment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jet_mobile_grad_assignment.data.models.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import com.example.jet_mobile_grad_assignment.util.Constants.Companion.TAG

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants: StateFlow<List<Restaurant>> = _restaurants.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    // Regex of valid UK postcodes
    val regex1 = Regex(pattern = "[A-Za-z]\\d\\d[A-Za-z][A-Za-z]", options = setOf(RegexOption.IGNORE_CASE)) // eg, A1 1AA
    val regex2 = Regex(pattern = "[A-Za-z]\\d\\d\\d[A-Za-z][A-Za-z]", options = setOf(RegexOption.IGNORE_CASE)) // eg, A11 1AA
    val regex3 = Regex(pattern = "[A-Za-z][A-Za-z]\\d\\d[A-Za-z][A-Za-z]", options = setOf(RegexOption.IGNORE_CASE)) // eg, AA1 1AA
    val regex4 = Regex(pattern = "[A-Za-z][A-Za-z]\\d\\d\\d[A-Za-z][A-Za-z]", options = setOf(RegexOption.IGNORE_CASE)) // eg, AA11 1AA
    val regex5 = Regex(pattern = "[A-Za-z]\\d[A-Za-z]\\d[A-Za-z][A-Za-z]", options = setOf(RegexOption.IGNORE_CASE)) // eg, A1A 1AA
    val regex6 = Regex(pattern = "[A-Za-z][A-Za-z]\\d[A-Za-z]\\d[A-Za-z][A-Za-z]", options = setOf(RegexOption.IGNORE_CASE)) // eg, AA1A 1AA

    // Coroutine to get the restaurant data from the api
    fun getRestaurants( postcode: String) {
        val newPostcode = cleanPostcode(postcode)

        // Check if the postcode is valid
        if (validPostcode(newPostcode)){
            viewModelScope.launch {
                val result = repository.getRestaurantsByPostcode(newPostcode)
                try {

                    // Check if the result is successful
                    if (result.isSuccessful) {
                        _restaurants.value = result.body()?.restaurants?.take(10) ?: emptyList()
                    } else {
                        _error.value = "Error: ${result.errorBody().toString()}"
                    }
                } catch (e: IOException) {
                    _error.value = "Network Error: ${e.message}"
                } catch (e: HttpException) {
                    _error.value = "HTTP Error: ${e.message}"
                } catch (e: Exception) {
                    _error.value = "Unexpected Error: ${e.message}"
                }
            }
        } else {
            //Log.d(TAG, "Invalid postcode format")
            _error.value = "Invalid postcode format"
        }
    }

    fun clearError() {
        _error.value = null
    }

    // Removes punctuation from postcode to be turned into API accepted format
    fun cleanPostcode( postcode: String): String {
        var newPostcode = postcode.filter { it.isLetterOrDigit() }
        return newPostcode
    }

    // Checks postcode is a valid UK format
    fun validPostcode(postcode: String): Boolean {
        return postcode.matches(regex1) ||
                postcode.matches(regex2) ||
                postcode.matches(regex3) ||
                postcode.matches(regex4) ||
                postcode.matches(regex5) ||
                postcode.matches(regex6)
    }
}