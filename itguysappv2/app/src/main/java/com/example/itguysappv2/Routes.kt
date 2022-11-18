package com.example.itguysappv2

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object ListeAvVarer : Routes(
        route = "visningavvarer",
        title = "VisningAvVarer",
        icon = Icons.Default.ShoppingCart
    )
    object VisningAvHandlekurv : Routes(
            route = "visningavhandlekurv",
            title = "VisningAvHandlekurv",
            icon = Icons.Default.ShoppingCart
    )
    object OmOss : Routes(
            route = "omoss",
            title = "OmOss",
            icon = Icons.Default.Person
    )
    object MinSide : Routes(
            route = "minside",
            title = "MinSide",
            icon = Icons.Default.Person
    )
    object Hjem : Routes(
            route = "hjem",
            title = "Hjem",
            icon = Icons.Default.Home    
    )
}


 