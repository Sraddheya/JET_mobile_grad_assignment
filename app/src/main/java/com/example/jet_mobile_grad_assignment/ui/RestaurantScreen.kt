package com.example.jet_mobile_grad_assignment.ui

import android.util.Log
import com.example.jet_mobile_grad_assignment.util.Constants.Companion.TAG
import android.widget.Toast
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.jet_mobile_grad_assignment.ui.theme.Charcoal
import com.example.jet_mobile_grad_assignment.ui.theme.Mozzarella
import com.example.jet_mobile_grad_assignment.ui.theme.Orange

@Composable
fun RestaurantScreen(viewModel: RestaurantViewModel) {

    var postcode by remember { mutableStateOf("") } // Holds postcode input
    val restaurantList by viewModel.restaurants.collectAsState(initial = emptyList()) // Holds the list of restaurants
    val error by viewModel.error.collectAsState(initial = null) // Holds any error messages
    val context = LocalContext.current // Context for Toast

    // Shows a toast on any errors and resets the state flows
    LaunchedEffect(error) {
        error?.let { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            viewModel.clearStateFlows()
        }
    }

    // Layout for the screen
    Scaffold(
        modifier = Modifier.padding(16.dp),
        contentWindowInsets = WindowInsets.safeDrawing // Prevents content from being obscured by system bars
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Text field for postcode input
                OutlinedTextField(
                    value = postcode,
                    onValueChange = { text ->
                        postcode = text
                    },
                    modifier = Modifier
                        .weight(1f),
                    shape = RoundedCornerShape(25.dp),
                    label = { Text("Postcode") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Mozzarella,
                        unfocusedContainerColor = Mozzarella,
                    )
                )
                Spacer( modifier = Modifier.width(10.dp))

                // Button to search for restaurants
                Button(
                    onClick = {
                        viewModel.getRestaurants(postcode)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange,
                        contentColor = Mozzarella
                    ))
                {
                    Text(text = "Search")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            // List of restaurant information
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(restaurantList) { restaurant ->
                    //Log.d(TAG, postcode)
                    RestaurantItem(restaurant)
                    HorizontalDivider( thickness = 1.dp, color = Charcoal)
                }
            }
        }
    }
}

// Format of the restaurant item displayed in the list
@Composable
fun RestaurantItem(restaurant: Restaurant) {
    Column(
        modifier = Modifier.padding(16.dp, 8.dp)
    ) {
        Text(text = "Name: ${restaurant.name}")
        Text(text = "Rating: ${restaurant.rating.starRating}")
        Text(text = "Address: ${restaurant.address}")
        Text(text = "Cuisine: ${restaurant.cuisines.joinToString { it.name }}")
    }
}