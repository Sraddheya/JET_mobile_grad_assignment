package com.example.jet_mobile_grad_assignment.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.jet_mobile_grad_assignment.R
import com.example.jet_mobile_grad_assignment.RestaurantRepository
import com.example.jet_mobile_grad_assignment.RestaurantViewModel
import com.example.jet_mobile_grad_assignment.RestaurantViewModelFactory
import com.example.jet_mobile_grad_assignment.adapters.RestaurantAdapter

const val TAG = "RESPONSE_LOG"

class MainActivity : AppCompatActivity() {

    // ViewModel to handle the restaurant data
    private lateinit var restaurantViewModel: RestaurantViewModel
    private lateinit var restaurantAdapter: RestaurantAdapter

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        val restaurantRepository = RestaurantRepository()
//        val restaurantViewModelFactory = RestaurantViewModelFactory(restaurantRepository)
//        restaurantViewModel = ViewModelProvider(this, restaurantViewModelFactory)[RestaurantViewModel::class.java]
//
//        val etSearch = findViewById<EditText>(R.id.etSearch)
//        val btSearch = findViewById<Button>(R.id.btSearch)
//
//        // Set up the RecyclerView
//        val recyclerView: RecyclerView = findViewById(R.id.rvRestaurant)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        restaurantAdapter = RestaurantAdapter()
//        recyclerView.adapter = restaurantAdapter
//
//        btSearch.setOnClickListener {
//            Log.d("POSTCODE", etSearch.text.toString())
//            val postcode = etSearch.text.toString()
//            if (postcode.isNotEmpty()) {
//                restaurantViewModel.getRestaurants(postcode)
//            }
//            Log.d("POSTCODE", etSearch.text.toString())
//        }
//
//        // Observe the restaurant data
//        restaurantViewModel.observeRestaurants().observe(this, Observer { restaurants ->
//            // Update the adapter with the new list of restaurants
//            restaurantAdapter.submitList(restaurants)
//
//            // Log the restaurant details
//            for (restaurant in restaurants) {
//                Log.d(TAG, "ID: ${restaurant.id}")
//                Log.d(TAG, "Restaurant: ${restaurant.name}")
//                Log.d(TAG, "Address: ${restaurant.address}")
//                Log.d(TAG, "Cuisine: ${restaurant.cuisines.joinToString(separator = ", ") { it.name }}")
//                Log.d(TAG, "Rating: ${restaurant.rating.starRating}")
//            }
//
//            // Log the number of restaurants received
//            //Log.d(TAG, "Number of restaurants received: ${restaurants.size}")
//            // Log the item count of the adapter
//            //Log.d(TAG, "Adapter item count: ${restaurantAdapter.itemCount}")
//        })
//
//        // Observe the error messages
//        restaurantViewModel.observeError().observe(this, Observer { errorMessage ->
//            Log.e(TAG, errorMessage)
//        })
//
//    }
}