package com.example.itguysappv2


/*class LogginVM : ViewModel() {
    private var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private lateinit var auth: FirebaseAuth
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
    )
    //Får svar om sign in funksjonen er velykket
    private fun signInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == ComponentActivity.RESULT_OK) {
            user = FirebaseAuth.getInstance().currentUser
            Log.e("MainActivity.kt", "Innlogging vellykket")
        } else {
            Log.e("MainActivity.kt", "Feil med innlogging" + response?.error?.errorCode)
        }
    }
}*/