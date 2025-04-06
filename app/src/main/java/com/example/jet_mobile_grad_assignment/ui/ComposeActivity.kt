package com.example.jet_mobile_grad_assignment.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jet_mobile_grad_assignment.repository.RestaurantRepository
import com.example.jet_mobile_grad_assignment.ui.RestaurantViewModel
import com.example.jet_mobile_grad_assignment.ui.RestaurantViewModelFactory
import com.example.jet_mobile_grad_assignment.ui.theme.JET_mobile_grad_assignmentTheme

class ComposeActivity : ComponentActivity() {

    private val repository by lazy { RestaurantRepository() }
    private val viewModelFactory by lazy { RestaurantViewModelFactory(repository) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: RestaurantViewModel by viewModels { viewModelFactory }

        setContent {
            JET_mobile_grad_assignmentTheme {
                Surface(
                    modifier = Modifier.Companion.fillMaxSize()
                ) {
                    RestaurantScreen(viewModel)
                }
            }
        }
    }
}