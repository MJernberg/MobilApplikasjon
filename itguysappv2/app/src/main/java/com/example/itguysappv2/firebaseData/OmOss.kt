package com.example.itguysappv2.firebaseData

import android.content.ContentValues.TAG
import android.util.Log
import com.example.itguysappv2.firebaseData.OmOssObject.omOssListe
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source

fun OmOss() {

    var firestore:FirebaseFirestore = FirebaseFirestore.getInstance()
    var docRef = firestore.collection("omoss")
    var source = Source.DEFAULT

    firestore.collection("omoss").get(source).addOnSuccessListener { snapshot ->
        for (document in snapshot.documents) {
            Log.d(TAG, "${document.id} => ${document.data}")
            var o1 = OmOssFB(
                bildeID = document["bildeID"].toString(),
                fornavn = document["fornavn"].toString(),
                etternavn = document["etternavn"].toString(),
                beskrivelse = document["beskrivelse"].toString(),
                alder = document["alder"].toString(),
            )
            omOssListe.add(o1)
            Log.d(TAG, document["tittel"].toString())
            Log.d(TAG, o1.toString())
        }
    }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Feil med henting av om oss data: ", exception)
            }
}
