package com.example.jet_mobile_grad_assignment.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jet_mobile_grad_assignment.R
import com.example.jet_mobile_grad_assignment.RestaurantAdapter
import com.example.jet_mobile_grad_assignment.RetrofitInstance
import com.example.jet_mobile_grad_assignment.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

const val TAG = "RESPONSE_LOG"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var restaurantAdapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialise Retrofit instance
        val restaurantAPI = RetrofitInstance.restaurantAPI

        // Coroutine to fetch data
        lifecycleScope.launch {
            try {
                val result = restaurantAPI.getRestaurantResponse()
                if (result.isSuccessful) {
                    Log.d(TAG, "Success!")
                    val restaurantResponse = result.body()
                    for (restaurant in restaurantResponse?.restaurants ?: emptyList()) {
                        Log.d(TAG, "ID: ${restaurant.id}")
                        Log.d(TAG, "Restaurant: ${restaurant.name}")
                        Log.d(TAG, "Address: ${restaurant.address}")
                        Log.d(TAG, "Cuisine: ${restaurant.cuisines.joinToString( separator = ", "){ it.name }}")
                        Log.d(TAG, "Rating: ${restaurant.rating.starRating}")
                    }
                } else {
                    Log.e(TAG, "Error: ${result.errorBody().toString()}")
                }
            } catch (e: java.io.IOException) {
                Log.e(TAG, "Network Error: ${e.message}")
            } catch (e: HttpException) {
                Log.e(TAG, "HTTP Error: ${e.message}")
            } catch (e: Exception) {
                Log.e(TAG, "Unexpected Error: ${e.message}")
            }
        }

//        var restaurantList = mutableListOf(
//            Restaurant("Nepal")
//        )
//
//        val recyclerView: RecyclerView = findViewById(R.id.rvRestaurant)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = RestaurantAdapter(restaurantList)
    }
}