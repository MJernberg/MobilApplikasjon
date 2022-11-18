package com.example.itguysappv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.CustomTopAppBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MinSide(navController: NavHostController) {
    var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "Min Side", true)
        }
            ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (firebaseUser != null) {
                    Text(
                        text = "Velkommen, " + firebaseUser.displayName + "!",
                        style = TextStyle(fontSize = 36.sp),
                        color = Color.DarkGray
                    )
                }

                Spacer(modifier = Modifier.height(100.dp))
            }

        }
    }
}
