package com.example.itguysappv2

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profileromoss(navController: NavHostController) {
    Scaffold(
        content = {
            Profilsideinnhold()
        }
    )

}