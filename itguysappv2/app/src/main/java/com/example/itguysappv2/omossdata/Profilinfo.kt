package com.example.itguysappv2.omossdata

import com.example.itguysappv2.R


object Profilinfo {

    val profil =
        Profil(
        id = 1,
        fornavn = "Dariusz",
        etternavn = "Jakimiuk",
        alder = 23,
        beskrivelse = "",
        profilbildeId = R.drawable.p8
        )

    val listeAvProfil = listOf(
        profil,
         Profil(
                id = 2,
                fornavn = "Magnus",
                etternavn = "Jernberg",
                alder = 21,
                beskrivelse = "",
                profilbildeId = R.drawable.p8
        ),

        Profil(
                id = 3,
                fornavn = "Sondre",
                etternavn = "W. Aarstad",
                alder = 26,
                beskrivelse = "",
                profilbildeId = R.drawable.p8
        ),
    )
}


