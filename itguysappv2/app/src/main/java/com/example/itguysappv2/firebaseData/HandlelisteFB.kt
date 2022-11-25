package com.example.itguysappv2.firebaseData

import com.google.firebase.firestore.Exclude

data class HandlelisteFB(
    var vareID: String,
    var tittel: String,
    val pris: String,
    val beskrivelse: String,
    val bildeID: String,
) {

    override fun toString(): String {
        return "$vareID $tittel $beskrivelse"
    }
}
