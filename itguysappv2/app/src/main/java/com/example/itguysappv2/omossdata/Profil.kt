package com.example.itguysappv2.omossdata

data class Profil (
    val id: Int,
    val fornavn: String,
    val etternavn: String,
    val alder: Int,
    val beskrivelse: String,
    val profilbildeId: Int = 0
)
