package com.example.jet_mobile_grad_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jet_mobile_grad_assignment.ui.theme.JET_mobile_grad_assignmentTheme
import kotlin.getValue

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
                    modifier = Modifier.fillMaxSize()
                ) {
                    RestaurantScreen(viewModel)
                }
            }
        }
    }
}