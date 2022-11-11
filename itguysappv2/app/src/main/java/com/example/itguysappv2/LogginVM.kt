package com.example.itguysappv2

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.itguysappv2.data.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.storage.FirebaseStorage


class LogginVM : ViewModel() {

    private lateinit var firestore : FirebaseFirestore
    private var storageReference = FirebaseStorage.getInstance().getReference()
    var user : User? = null

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun saveUser() {
        user?.let {
            user ->
            val handle = firestore.collection("users").document(user.uid).set(user)
            handle.addOnSuccessListener { Log.d("Firebase", "Lagret") }
            handle.addOnFailureListener { Log.e("Firebase", "Feil med lagring") }
        }
    }

    fun velkommenVidere() {

    }


}