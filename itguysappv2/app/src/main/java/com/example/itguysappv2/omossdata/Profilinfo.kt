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
        profilbildeId = R.drawable.p1
        )

    val listeAvProfil = listOf(
        profil,
         Profil(
                id = 2,
                fornavn = "Magnus",
                etternavn = "Jernberg",
                alder = 21,
                beskrivelse = "",
                profilbildeId = R.drawable.p1
            ),

        Profil(
                id = 3,
                fornavn = "Testigen",
                etternavn = "Testenensenerenen ",
                alder = 500,
                beskrivelse = "Dette er en test for å teste om dette fungere over flere rader, slik at vi ikke bare får alt på samme linje",
                profilbildeId = R.drawable.p1
                    ),
    )
}


