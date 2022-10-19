package com.example.itguysappv2.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.CustomTopAppBar
import com.example.itguysappv2.Routes

@Composable
fun SignUp(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBar(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithTopBar(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "Registrering", true)
        }, content = {
            Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val username = remember { mutableStateOf(TextFieldValue()) }
                    val fornavn = remember { mutableStateOf(TextFieldValue()) }
                    val etternavn = remember { mutableStateOf(TextFieldValue()) }
                    val password = remember { mutableStateOf(TextFieldValue()) }
                    val sjekkpassword = remember { mutableStateOf(TextFieldValue()) }

                    Text(text = "Registrer deg", style = TextStyle(fontSize = 40.sp))

                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        label = { Text(text = "Fornavn") },
                        value = fornavn.value,
                        onValueChange = { fornavn.value = it })

                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        label = { Text(text = "Etternavn") },
                        value = etternavn.value,
                        onValueChange = { etternavn.value = it })

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
                    TextField(
                        label = { Text(text = "Bekreft passord") },
                        value = sjekkpassword.value,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        onValueChange = { sjekkpassword.value = it })

                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = { navController.navigate(Routes.Login.route) },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Registrer deg")
                        }
                    }
                }

        })
}