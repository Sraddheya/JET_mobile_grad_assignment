package com.example.jet_mobile_grad_assignment.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer

import com.example.jet_mobile_grad_assignment.R
import com.example.jet_mobile_grad_assignment.RestaurantViewModel
import com.example.jet_mobile_grad_assignment.databinding.ActivityMainBinding

const val TAG = "RESPONSE_LOG"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var restaurantAdapter: RestaurantAdapter

    // ViewModel to handle the restaurant data
    private val restaurantViewModel: RestaurantViewModel by viewModels()

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

        // Method to get the restaurant data via the ViewModel
        restaurantViewModel.getRestaurants()

        // Observe the restaurant data
        restaurantViewModel.observeRestaurants().observe(this, Observer { restaurants ->
            for (restaurant in restaurants) {
                Log.d(TAG, "ID: ${restaurant.id}")
                Log.d(TAG, "Restaurant: ${restaurant.name}")
                Log.d(TAG, "Address: ${restaurant.address}")
                Log.d(TAG, "Cuisine: ${restaurant.cuisines.joinToString(separator = ", ") { it.name }}")
                Log.d(TAG, "Rating: ${restaurant.rating.starRating}")
            }
        })

        // Observe the error messages
        restaurantViewModel.observeError().observe(this, Observer { errorMessage ->
            Log.e(TAG, errorMessage)
        })

//        var restaurantList = mutableListOf(
//            Restaurant("Nepal")
//        )
//
//        val recyclerView: RecyclerView = findViewById(R.id.rvRestaurant)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = RestaurantAdapter(restaurantList)
    }
}