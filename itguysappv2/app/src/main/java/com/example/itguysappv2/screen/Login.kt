package com.example.itguysappv2.screen

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth



/*@Composable
fun LoginPage(navHostController: NavHostController) {
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
    if (result.resultCode == ComponentActivity.RESULT_OK) {
        user = FirebaseAuth.getInstance().currentUser
        Log.e("MainActivity.kt", "Innlogging vellykket")
    } else {
        Log.e("MainActivity.kt", "Feil med innlogging" + response?.error?.errorCode)
    }
}*/

