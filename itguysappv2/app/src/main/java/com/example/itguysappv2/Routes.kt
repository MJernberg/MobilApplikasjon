package com.example.itguysappv2


sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object SignUp : Routes("SignUp")
    object ForgotPassword : Routes("ForgotPassword")
    object Vareliste : Routes("Vareliste")
    object Handlekurv : Routes("Handlekurv")
    object Profileromoss : Routes("Profileromoss")
}