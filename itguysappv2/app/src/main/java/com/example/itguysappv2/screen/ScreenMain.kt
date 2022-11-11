package com.example.itguysappv2.screen


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.itguysappv2.Handlekurv
import com.example.itguysappv2.Routes
import com.example.itguysappv2.firebaseData.OmOssObject
import com.example.itguysappv2.firebaseData.VarerObject
import com.example.itguysappv2.firebaseData.VisningAvOmOss
import com.example.itguysappv2.firebaseData.VisningAvVarer


@Composable
fun ScreenMain(){

    val navController = rememberNavController()

    NavHost(navController = navController,
    startDestination = Routes.Hjem.route
    ) {

       composable(Routes.ListeAvVarer.route) {
           VisningAvVarer(navController, VarerObject.varerListe)
       }

       composable(Routes.Handlekurv.route) {
            Handlekurv(navController = navController)
        }
        
        composable(Routes.OmOss.route) {
            VisningAvOmOss(navController, OmOssObject.omOssListe)
        }

        composable(Routes.Hjem.route) {
            Hjem(navController = navController)
        }

   }
}





