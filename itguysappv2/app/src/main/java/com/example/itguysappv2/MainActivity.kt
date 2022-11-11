package com.example.itguysappv2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.itguysappv2.component.ui.theme.ITGuysTheme
import com.example.itguysappv2.component.ui.theme.farge2
import com.example.itguysappv2.data.User
import com.example.itguysappv2.firebaseData.OmOss
import com.example.itguysappv2.firebaseData.Varer
import com.example.itguysappv2.screen.ScreenMain
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : ComponentActivity() {

    private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    val viewModel = LogginVM()
    var mainActivity: MainActivity? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = this
        Varer()
        OmOss()


        setContent {
            firebaseUser?.let{
                val user = User(it.uid, "")
                viewModel.user = user
            }
            ITGuysTheme {
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

//Login siden, der vi kan logge oss inn i appen, eller registrere ny bruker

    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun LoginPage() {
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

            Text(text = "Velkommen til ITGuys", style = TextStyle(fontSize = 36.sp), color = androidx.compose.ui.graphics.Color.DarkGray)



            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    colors = mainButtonColor,
                    onClick = { signIn() },
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Logg inn", color = androidx.compose.ui.graphics.Color.White)
                }
            }
        }
    }

//Slår sammen signInResult og signin
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) {
        res -> this.signInResult(res)
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
        .setLogo(R.drawable.handlekurvlogo)
        .build()

        signInLauncher.launch(signinIntent)
    }



//Får svar om sign in funksjonen er velykket
    private fun signInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            firebaseUser = FirebaseAuth.getInstance().currentUser
            Log.e("MainActivity.kt", "Innlogging vellykket")
            setContent {
                DefaultPreview()
            }
            firebaseUser?.let{
                val user = User(it.uid, it.displayName)
                viewModel.user = user
                viewModel.saveUser()
            }
        } else {
            Log.e("MainActivity.kt", "Feil med innlogging" + response?.error?.errorCode)
        }
    }
}

@Composable
fun DefaultPreview() {
    ITGuysTheme {
        ScreenMain()
    }
}