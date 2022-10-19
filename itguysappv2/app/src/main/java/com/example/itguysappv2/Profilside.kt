package com.example.itguysappv2

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.itguysappv2.omossdata.Profilinfo


@Composable
fun Profilsideinnhold() {
    val profiler = remember { Profilinfo.listeAvProfil }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = profiler,
            itemContent = {
                ProfilListeItem(profil = it)
            }
        )
    }
}