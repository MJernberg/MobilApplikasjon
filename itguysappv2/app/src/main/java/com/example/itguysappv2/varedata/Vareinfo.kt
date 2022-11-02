package com.example.itguysappv2.varedata

import com.example.itguysappv2.R

object Vareinfo {

    val vare =
        Vare(
        id = 1,
        tittel = "Instalasjon av Harddisk",
        pris = 500,
        beskrivelse = "",
        bildeId = R.drawable.p1
        )

    val listeAvVarer = listOf(
        vare,
        Vare(
            id = 2,
            tittel = "Oppsett av Annen Server",
            pris = 5000,
            beskrivelse = "",
            bildeId = R.drawable.p2

        ),

        Vare(
            id = 3,
            tittel = "Oppsett av WINDOWS Server",
            pris = 4000,
            beskrivelse = "",
            bildeId = R.drawable.p3

        ),

        Vare(
            id = 4,
            tittel = "Reset og nytt oppsett av PC",
            pris = 1000,
            beskrivelse = "",
            bildeId = R.drawable.p4

        ),

        Vare(
            id = 5,
            tittel = "Hjelp med reset av PC",
            pris = 1000,
            beskrivelse = "",
            bildeId = R.drawable.p5
        ),

        Vare(
            id = 6,
            tittel = "Oppsett av WINDOWS maskin",
            pris = 1000,
            beskrivelse = "Oppsett av WINDOWS maskin",
            bildeId = R.drawable.p6
        ),
    )
}


