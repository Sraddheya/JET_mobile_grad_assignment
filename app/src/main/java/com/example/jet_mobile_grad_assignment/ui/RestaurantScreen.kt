package com.example.jet_mobile_grad_assignment.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.jet_mobile_grad_assignment.data.models.Restaurant
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.example.jet_mobile_grad_assignment.util.Constants.Companion.TAG

@Composable
fun RestaurantScreen(viewModel: RestaurantViewModel) {
    var postcode by remember { mutableStateOf("") }
    val restaurantList by viewModel.restaurants.collectAsState(initial = emptyList())
    val error by viewModel.error.collectAsState(initial = null)
    val context = LocalContext.current

    LaunchedEffect(error) {
        error?.let { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            viewModel.clearStateFlows()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = postcode,
                onValueChange = { text ->
                    postcode = text
                }
            )

            Button(
                onClick = {
                    viewModel.getRestaurants(postcode)
                }) {
                Text(text = "Submit")
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(restaurantList) { restaurant ->
                Log.d(TAG, postcode)
                Log.d(TAG, restaurant.name)
                RestaurantItem(restaurant)
            }
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "Name: ${restaurant.name}")
        Text(text = "Address: ${restaurant.address}")
        Text(text = "Cuisine: ${restaurant.cuisines.joinToString { it.name }}")
        Text(text = "Rating: ${restaurant.rating.starRating}")
    }
}