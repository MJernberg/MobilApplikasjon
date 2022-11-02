package com.example.itguysappv2

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
import com.example.itguysappv2.ui.theme.JetpackComposeDemoTheme
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                 Surface(
                         modifier = Modifier.fillMaxSize(),
                          color = MaterialTheme.colors.background
                                ) {
                    //ScreenMain()
                    LoginPage()
                }
            }
        }
    }
    private var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private lateinit var auth: FirebaseAuth

//Login siden, der vi kan logge oss inn i appen, eller regesitere ny bruker

    @Composable
    fun LoginPage() {
        Box(modifier = Modifier.fillMaxSize()) {
        }
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Velkommen til ITGuys", style = TextStyle(fontSize = 36.sp))

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { signIn() },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Logg inn")
                }
            }
        }
    }

//Åpner opp sign in vinduet
    private fun signIn() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        val signinIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()

        signInLauncher.launch(signinIntent)
    }


//Slår sammen signInResult og signin
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) {
        res -> this.signInResult(res)
    }
//Får svar om sign in funksjonen er velykket
    private fun signInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            user = FirebaseAuth.getInstance().currentUser
            Log.e("MainActivity.kt", "Innlogging vellykket")
        } else {
            Log.e("MainActivity.kt", "Feil med innlogging" + response?.error?.errorCode)
        }
    }
}