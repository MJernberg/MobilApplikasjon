package com.example.itguysappv2.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.itguysappv2.Handlekurv
import com.example.itguysappv2.Routes
import com.example.itguysappv2.Vareliste
import com.example.itguysappv2.Profileromoss


@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            ForgotPassword(navController = navController)
        }

        composable(Routes.Vareliste.route) { navBackStack ->
           Vareliste(navController = navController)
       }

       composable(Routes.Handlekurv.route) { navBackStack ->
            Handlekurv(navController = navController)
        }
        
        composable(Routes.Profileromoss.route) { navBackStack ->
            Profileromoss(navController = navController)
        }

   }
}



