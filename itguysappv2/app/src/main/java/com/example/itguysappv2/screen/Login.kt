package com.example.itguysappv2.screen
/*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.Routes
import com.example.itguysappv2.ui.theme.Purple700
import com.google.firebase.auth.FirebaseAuth

private lateinit var auth: FirebaseAuth


    @Composable
    fun LoginPage(navController: NavHostController) {
        Box(modifier = Modifier.fillMaxSize()) {
            ClickableText(
                text = AnnotatedString("Registrer deg"),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = { navController.navigate(Routes.SignUp.route) },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline,
                    color = Purple700
                )
            )
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val username = remember { mutableStateOf(TextFieldValue()) }
            val password = remember { mutableStateOf(TextFieldValue()) }

            Text(text = "Logg inn", style = TextStyle(fontSize = 40.sp))

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Epost") },
                value = username.value,
                onValueChange = { username.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Passord") },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password.value = it })

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { navController.navigate(Routes.Vareliste.route)},
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Logg inn")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            ClickableText(
                text = AnnotatedString("Glemt passord?"),
                onClick = { navController.navigate(Routes.ForgotPassword.route) },
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Default
                )
            )
        }
    }
    */

