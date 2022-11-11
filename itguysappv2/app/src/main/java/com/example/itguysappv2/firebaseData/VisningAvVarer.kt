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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.CustomTopAppBar
import com.example.itguysappv2.component.ui.theme.farge3


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisningAvVarer(navController: NavHostController, varerListe: MutableList<VareFB>) {
    Scaffold(
            topBar = {
                CustomTopAppBar(navController, "Vareliste", true)
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
                            VareKolonne(varerListe)

                            Spacer(modifier = Modifier.height(100.dp))
                        }

                    }
                }
            }

@Composable
fun VareKolonne(varerListe: MutableList<VareFB> ) {
    Row(modifier = Modifier
            .height(150.dp)
             .horizontalScroll(rememberScrollState(), enabled = true),
        ) {
            for (vare in varerListe){
                Log.d(ContentValues.TAG, "Test")
                VareKort(
                    vare.tittel,
                    vare.pris.toString(),
                    vare.beskrivelse,
                    vare. bildeID
                )
            }
        }
    }

@Composable
fun KortLabel(tittel: String) {
    Text(
        text = tittel,
        modifier = Modifier
            .absolutePadding(bottom = Dp(5f))
            .background(Color.Transparent),
        textAlign = TextAlign.Right,
        fontSize = 20.sp,
        color = farge3
    )
}

@Composable
fun VareKort(tittel: String, pris: String, beskrivelse: String, bildeID: String) {
    Log.d(ContentValues.TAG, tittel)
    Card (
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .absolutePadding(right = Dp(35f))
            .clickable { println(tittel + " er klikket på") },
        shape = RoundedCornerShape(8.dp)
        ) {
             Row() {
                        Column(modifier = Modifier
                            .padding(horizontal = 19.dp)
                            .fillMaxHeight()
                            .background(Color.Transparent),

                            ) {
                            KortLabel(tittel)
                            KortLabel(beskrivelse)
                            KortLabel(pris + "kr")
                        }

                    }    
    }
}