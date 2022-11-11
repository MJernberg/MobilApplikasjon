package com.example.itguysappv2.firebaseData

import com.google.firebase.firestore.Exclude

data class OmOssFB(
    val bildeID: String,
    val fornavn: String,
    val etternavn: String,
    val beskrivelse: String,
    val alder: String,
) {
    @Exclude
    fun toMap(): Map<String, Any> {
        return mapOf(
            "bildeID" to bildeID,
            "fornavn" to fornavn,
            "etternavn" to etternavn,
            "beskrivelse" to beskrivelse,
            "alder" to alder
        )
    }
}
