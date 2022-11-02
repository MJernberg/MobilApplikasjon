package com.example.itguysappv2.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.Routes
import com.example.itguysappv2.screen.ScreenMain
import com.example.itguysappv2.ui.theme.JetpackComposeDemoTheme
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

@Composable
    fun Hjem(navController: NavHostController) {
        Box(modifier = Modifier.fillMaxSize()) {
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Hjem", style = TextStyle(fontSize = 36.sp))

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 10.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { navController.navigate(Routes.Vareliste.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Vareliste")
                }
            }
            Box(modifier = Modifier.padding(40.dp, 10.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { navController.navigate(Routes.Handlekurv.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Handlekurv")
                }
            }
            Box(modifier = Modifier.padding(40.dp, 10.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { navController.navigate(Routes.Profileromoss.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Om Oss")
                }
            }
        }
    }