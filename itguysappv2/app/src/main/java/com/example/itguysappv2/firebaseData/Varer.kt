package com.example.itguysappv2.firebaseData

import android.content.ContentValues.TAG
import android.util.Log
import com.example.itguysappv2.firebaseData.VarerObject.varerListe
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source

fun Varer() {

    var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    var docRef = firestore.collection("varer")
    var source = Source.DEFAULT

    firestore.collection("varer").get(source).addOnSuccessListener { snapshot ->
        for (document in snapshot.documents) {
            Log.d(TAG, "${document.id} => ${document.data}")
            var v1 = VareFB(
                tittel = document["tittel"].toString(),
                pris = document.getDouble("pris"),
                beskrivelse = document["beskrivelse"].toString(),
                bildeID = document["bildeID"].toString(),
            )
            varerListe.add(v1)
            Log.d(TAG, document["tittel"].toString())
            Log.d(TAG, v1.toString())
        }
    }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Feil med henting av varer: ", exception)
            }
}