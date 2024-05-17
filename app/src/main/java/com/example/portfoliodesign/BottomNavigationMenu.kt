package com.example.portfoliodesign

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationMenu(selectedItem: Int, onItemSelected: (Int) -> Unit) {
    BottomAppBar(
        contentColor = Color.Black
    ) {
        NavigationBarItem(icon = { Icon(Icons.Filled.Done, contentDescription = "Watchlist") },
            label = { Text("Watchlist") },
            selected = selectedItem == 0,
            onClick = { onItemSelected(0) })
        NavigationBarItem(icon = { Icon(Icons.Filled.AddCircle, contentDescription = "Orders") },
            label = { Text("Orders") },
            selected = selectedItem == 1,
            onClick = { onItemSelected(1) })
        NavigationBarItem(icon = { Icon(Icons.Filled.DateRange, contentDescription = "Portfolio") },
            label = { Text("Portfolio") },
            selected = selectedItem == 2,
            onClick = { onItemSelected(2) })
        NavigationBarItem(icon = {
            Icon(
                Icons.Filled.FavoriteBorder, contentDescription = "Funds"
            )
        },
            label = { Text("Funds") },
            selected = selectedItem == 3,
            onClick = { onItemSelected(3) })
        NavigationBarItem(icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Invest") },
            label = { Text("Invest") },
            selected = selectedItem == 4,
            onClick = { onItemSelected(4) })
    }
}