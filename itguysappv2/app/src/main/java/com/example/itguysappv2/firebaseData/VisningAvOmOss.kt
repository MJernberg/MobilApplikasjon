package com.example.itguysappv2.firebaseData

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.itguysappv2.CustomTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisningAvOmOss(navController: NavHostController, omOssListe: MutableList<OmOssFB>) {
    Scaffold(
            topBar = {
                CustomTopAppBar(navController, "Om Oss", true)
            }
        ) {

                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Column(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState(),enabled = true),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            OmOssKolonne(omOssListe)

                            Spacer(modifier = Modifier.height(100.dp))
                        }

                    }
                }
            }

@Composable
fun OmOssKolonne(omOssListe: MutableList<OmOssFB> ) {
    Row() {
        Column() {
            for (omOss in omOssListe){
                Log.d(ContentValues.TAG, "omOmListe ok!")
                OmOssKort(
                    omOss.fornavn,
                    omOss.etternavn,
                    omOss.alder,
                    omOss.beskrivelse
                )
            }
        }

    }
}

@Composable
fun OmOssKort(fornavn: String, etternavn: String, beskrivelse: String, alder: String) {
    Log.d(ContentValues.TAG, "Test")
    Card (
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .absolutePadding(bottom = Dp(35f))
            .clickable { println(fornavn + " " + etternavn + " er klikket på") },
        shape = RoundedCornerShape(8.dp)
        ) {
        Row() {
            Column(modifier = Modifier
                .padding(horizontal = 19.dp)
                .fillMaxHeight()
                .background(Color.Transparent),

                ) {
                KortLabel(fornavn + " " + etternavn)
                KortLabel(alder)
                KortLabel(beskrivelse)
            }

        }

    }
}