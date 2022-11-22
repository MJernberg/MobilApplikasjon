package com.example.itguysappv2.firebaseData

data class VareFB(
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
