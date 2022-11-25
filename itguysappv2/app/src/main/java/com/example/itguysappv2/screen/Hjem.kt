package com.example.itguysappv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.LogginVM
import com.example.itguysappv2.Routes
import com.example.itguysappv2.component.ui.theme.farge2

@Composable
    fun Hjem(navController: NavHostController) {
    val viewModel = LogginVM()
    val mainButtonColor = ButtonDefaults.buttonColors(
            containerColor = farge2,
            contentColor = androidx.compose.ui.graphics.Color.White
        )
        Box(modifier = Modifier.fillMaxSize()) {
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Hjem", style = TextStyle(fontSize = 36.sp), color = androidx.compose.ui.graphics.Color.DarkGray)

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 10.dp, 40.dp, 0.dp)) {
                Button(
                    colors = mainButtonColor,
                    onClick = { navController.navigate(Routes.ListeAvVarer.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Vareliste", style = TextStyle(fontSize = 20.sp), color = androidx.compose.ui.graphics.Color.White)
                }
            }
            Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 0.dp)) {
                Button(
                    colors = mainButtonColor,
                    onClick = { navController.navigate(Routes.VisningAvHandlekurv.route); viewModel.listenToHandlekurv() },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Handlekurv", style = TextStyle(fontSize = 20.sp), color = androidx.compose.ui.graphics.Color.White)
                }
            }
            Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 0.dp)) {
                Button(
                    colors = mainButtonColor,
                    onClick = { navController.navigate(Routes.OmOss.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Om Oss", style = TextStyle(fontSize = 20.sp), color = androidx.compose.ui.graphics.Color.White)
                }
            }

            Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 0.dp)) {
                Button(
                    colors = mainButtonColor,
                    onClick = { navController.navigate(Routes.MinSide.route) },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Min Side", style = TextStyle(fontSize = 20.sp), color = androidx.compose.ui.graphics.Color.White)
                }
            }
        }
    }