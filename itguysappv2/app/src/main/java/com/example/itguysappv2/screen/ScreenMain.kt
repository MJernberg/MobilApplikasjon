package com.example.itguysappv2.screen


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.itguysappv2.Handlekurv
import com.example.itguysappv2.Profileromoss
import com.example.itguysappv2.Routes
import com.example.itguysappv2.Vareliste


@Composable
fun ScreenMain(){

    val navController = rememberNavController()

    NavHost(navController = navController,
    startDestination = Routes.Hjem.route
    ) {

        composable(Routes.Vareliste.route) {
           Vareliste(navController = navController)
       }

       composable(Routes.Handlekurv.route) {
            Handlekurv(navController = navController)
        }
        
        composable(Routes.Profileromoss.route) {
            Profileromoss(navController = navController)
        }

        composable(Routes.Hjem.route) {
            Hjem(navController = navController)
        }

   }
}





