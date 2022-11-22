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
import coil.compose.AsyncImage
import com.example.itguysappv2.CustomTopAppBar
import com.example.itguysappv2.LogginVM
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
                            Text(text = "Trykk på en vare for å legge den til i handlekurven din")
                            VareKolonne(varerListe)

                            Spacer(modifier = Modifier.height(100.dp))
                        }

                    }
                }
            }

@Composable
fun VareKolonne(varerListe: MutableList<VareFB> ) {
    Row() {
        Column() {
            for (vare in varerListe){
                Log.d(ContentValues.TAG, "Test")
                VareKort(
                    vare.vareID,
                    vare.tittel,
                    vare.pris,
                    vare.beskrivelse,
                    vare.bildeID
                )
            }
        }

    }
}

@Composable
fun KortLabel(tittel: String, textAlign: TextAlign) {
    Text(
        text = tittel,
        modifier = Modifier
            .absolutePadding(bottom = Dp(5f))
            .background(Color.Transparent),
        textAlign = textAlign,
        fontSize = 20.sp,
        color = farge3
    )
}

@Composable
fun VareKort(vareID: String, tittel: String, pris: String, beskrivelse: String, bildeID: String) {
    val viewModel = LogginVM()
    Log.d(ContentValues.TAG, tittel)
    Card (
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .absolutePadding(bottom = Dp(35f))
            .clickable { viewModel.saveHandlekruv(vareID, tittel, pris, beskrivelse, bildeID) },
        shape = RoundedCornerShape(8.dp)
        ) {
             Row() {

                Column(modifier = Modifier
                    .padding(horizontal = 19.dp)
                    .fillMaxHeight()
                    .background(Color.Transparent),

                    ) {
                    KortLabel(tittel + "\n", TextAlign.Justify)
                    KortLabel(pris + "kr" + "\n", TextAlign.Justify)
                }
                 AsyncImage(
                     model = bildeID,
                     contentDescription = tittel,
                     modifier = Modifier
                         .fillMaxSize()
                         .weight(1f),
                     alignment = Alignment.CenterEnd
                 )
                }
    }
}