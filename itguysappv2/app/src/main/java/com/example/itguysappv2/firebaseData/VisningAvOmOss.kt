package com.example.itguysappv2.firebaseData

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.itguysappv2.CustomTopAppBar
import com.example.itguysappv2.component.ui.theme.farge2


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
                            HvorErVi()
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
                    omOss.beskrivelse,
                    omOss.bildeID
                )
            }
        }

    }
}

@Composable
fun OmOssKort(fornavn: String, etternavn: String, beskrivelse: String, alder: String, bildeID: String) {
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
                KortLabel(fornavn + " " + etternavn, TextAlign.Left)
                KortLabel(alder, TextAlign.Left)
                KortLabel(beskrivelse, TextAlign.Left)
            }
            AsyncImage(
                    model = bildeID,
            contentDescription = fornavn + " " + etternavn,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            alignment = Alignment.CenterEnd
            )

        }

    }
}

@Composable
fun HvorErVi() {
    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = farge2,
        contentColor = Color.White
    )
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW,
        Uri.parse("https://itguysappv2.page.link/HvorErVi")) }

    Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 0.dp)) {
        Button(
            colors = mainButtonColor,
            onClick = {context.startActivity(intent)},
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            androidx.compose.material.Text(
                text = "Du finner oss her!",
                style = TextStyle(fontSize = 20.sp),
                color = Color.White
            )
        }
    }
}