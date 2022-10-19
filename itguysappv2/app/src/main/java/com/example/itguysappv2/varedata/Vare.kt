package com.example.itguysappv2.varedata

data class Vare ( 
    val id: Int,
    val tittel: String,
    val pris: Int,
    val beskrivelse: String,
    val bildeId: Int = 0
)
