package com.example.itguysappv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.*
import com.example.itguysappv2.component.ui.theme.farge2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MinSide(navController: NavHostController) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = Color.Red,
        contentColor = Color.Black
    )
    val subButtonColor = ButtonDefaults.buttonColors(
        containerColor = farge2,
        contentColor = Color.White
    )
    val viewModel = LogginVM()
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
                    Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 0.dp)) {
                        Button(
                            colors = subButtonColor,
                            onClick = { passordReset() },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Be om passord reset", style = TextStyle(fontSize = 20.sp), color = Color.White)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier.padding(40.dp, 200.dp, 40.dp, 0.dp)) {
                    Button(
                        colors = mainButtonColor,
                        onClick = { viewModel.slettBruker() },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Slett meg!"
                            , style = TextStyle(fontSize = 20.sp)
                            , color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(100.dp))
            }

        }
    }
}

fun passordReset() {
    var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    val epost = firebaseUser?.email

    Firebase.auth.sendPasswordResetEmail(epost.toString())
}
