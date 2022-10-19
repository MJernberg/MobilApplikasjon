package com.example.itguysappv2.varedata

import com.example.itguysappv2.R

object Vareinfo {

    val vare =
        Vare(
        id = 1,
        tittel = "Test1",
        pris = 500,
        beskrivelse = "",
        bildeId = R.drawable.p1
        )

    val listeAvVarer = listOf(
        vare,
        Vare(
            id = 2,
            tittel = "Test2",
            pris = 999,
            beskrivelse = "",
            bildeId = R.drawable.p2

        ),

        Vare(
            id = 3,
            tittel = "Test3",
            pris = 5000,
            beskrivelse = "",
            bildeId = R.drawable.p3

        ),

        Vare(
            id = 4,
            tittel = "Test4",
            pris = 1000,
            beskrivelse = "",
            bildeId = R.drawable.p4

        ),

        Vare(
            id = 5,
            tittel = "Test5",
            pris = 1000,
            beskrivelse = "",
            bildeId = R.drawable.p5
        ),

        Vare(
            id = 6,
            tittel = "Test6",
            pris = 1000,
            beskrivelse = "",
            bildeId = R.drawable.p6
        ),
    )
}


