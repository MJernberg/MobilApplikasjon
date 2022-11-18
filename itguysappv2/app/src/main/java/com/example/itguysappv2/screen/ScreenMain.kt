package com.example.itguysappv2.screen


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.itguysappv2.Routes
import com.example.itguysappv2.firebaseData.*


@Composable
fun ScreenMain(){

    val navController = rememberNavController()

    NavHost(navController = navController,
    startDestination = Routes.Hjem.route
    ) {

       composable(Routes.ListeAvVarer.route) {
           VisningAvVarer(navController, VarerObject.varerListe)
       }

        composable(Routes.VisningAvHandlekurv.route) {
           VisningAvHandlekurv(navController, HandlelisteObject.handlelisteListe)
       }
        
        composable(Routes.OmOss.route) {
            VisningAvOmOss(navController, OmOssObject.omOssListe)
        }

        composable(Routes.MinSide.route) {
            MinSide(navController)
        }

        composable(Routes.Hjem.route) {
            Hjem(navController = navController)
        }

   }
}





