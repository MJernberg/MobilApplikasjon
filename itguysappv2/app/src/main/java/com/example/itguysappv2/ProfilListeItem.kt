package com.example.itguysappv2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.itguysappv2.omossdata.Profil

@Composable
fun ProfilListeItem(profil : Profil) {
    Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
            Row (
                    ){
                ProfilBilde(profil = profil)
            Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                ) {
            Text(text = profil.fornavn + " " + profil.etternavn + ", " + profil.alder, style = typography.h6)
            Text(text = profil.beskrivelse, style = typography.caption)
        }
        }
    }
}

@Composable
private fun ProfilBilde(profil : Profil){
    Image(
        painter = painterResource(id = profil.profilbildeId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(CircleShape)
    )
}