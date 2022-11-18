package com.example.itguysappv2.firebaseData

import android.content.ContentValues.TAG
import android.util.Log
import com.example.itguysappv2.firebaseData.HandlelisteObject.handlelisteListe
import com.example.itguysappv2.firebaseData.VarerObject.varerListe
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source

fun Handleliste() {

    var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    var source = Source.DEFAULT
    var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser

    firebaseUser?.let {
        firestore.collection("users").document(it.uid).collection("handlekurv").get(source).addOnSuccessListener { snapshot ->
        for (document in snapshot.documents) {
            Log.d(TAG, "${document.id} => ${document.data}")
            var h1 = HandlelisteFB(
                vareID = document["vareID"].toString(),
                tittel = document["tittel"].toString(),
                pris = document["pris"].toString(),
                beskrivelse = document["beskrivelse"].toString(),
                bildeID = document["bildeID"].toString(),
            )
            handlelisteListe.add(h1)
            Log.d(TAG, document["tittel"].toString())
            Log.d(TAG, h1.toString())
        }
    }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Feil med henting av varer: ", exception)
            }
    }
}