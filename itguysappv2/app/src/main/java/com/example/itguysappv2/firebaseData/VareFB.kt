package com.example.itguysappv2.firebaseData

import com.google.firebase.firestore.Exclude

data class VareFB (
    val tittel: String,
    val pris: Double?,
    val beskrivelse: String,
    val bildeID: String,
) {
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "tittel" to tittel,
            "pris" to pris,
            "beskrivelse" to beskrivelse,
            "bildeID" to bildeID,
        )
    }

}
