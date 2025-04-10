package com.example.buoi2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buoi2.screen.ListProductScreen
import com.example.buoi2.screen.LoginScreen
import com.example.buoi2.ui.theme.Buoi2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Buoi2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "ListProductScreen"){
        composable("LoginScreen"){
            LoginScreen(navController)
        }
        composable("ListProductScreen") {
            ListProductScreen(navController)
        }
    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Buoi2Theme {
        MyApp()
    }
}