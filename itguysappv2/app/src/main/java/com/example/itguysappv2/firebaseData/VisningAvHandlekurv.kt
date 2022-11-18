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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.itguysappv2.CustomTopAppBar
import com.example.itguysappv2.LogginVM
import com.example.itguysappv2.Routes
import com.example.itguysappv2.component.ui.theme.farge2
import com.example.itguysappv2.component.ui.theme.farge3
import com.example.itguysappv2.firebaseData.HandlelisteObject.handlelisteListe


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisningAvHandlekurv(navController: NavHostController, handlelisteListe: MutableList<HandlelisteFB>) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = farge2,
        contentColor = androidx.compose.ui.graphics.Color.White
    )
    val viewModel = LogginVM()

    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "Handlekurv", true)
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
                HandleKolonne(handlelisteListe)

                Spacer(modifier = Modifier.height(100.dp))
            }

        }
    }
}

@Composable
fun HandleKolonne(handlelisteListe: MutableList<HandlelisteFB> ) {
    Row() {
        Column() {
            for (vare in handlelisteListe){
                Log.d(ContentValues.TAG, "Test")
                HandleKort(
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
fun HandleKort(vareID: String, tittel: String, pris: String, beskrivelse: String, bildeID: String) {
    Log.d(ContentValues.TAG, tittel)
    Card (
        modifier = Modifier
            .width(350.dp)
            .height(150.dp)
            .absolutePadding(bottom = Dp(35f))
            .clickable {},
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