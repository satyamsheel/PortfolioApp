package com.example.portfoliodesign.presentation.feature.portfolio.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.portfoliodesign.BottomNavigationMenu
import com.example.portfoliodesign.presentation.feature.portfolio.state.UserHoldingUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserHoldingsScreen(data: UserHoldingUiState) {
    Scaffold(bottomBar = { BottomNavigationMenu(2) {} }, topBar = {
        TopAppBar(actions = {
            Icon(
                Icons.Rounded.Notifications,
                contentDescription = "Watchlist",
                modifier = Modifier.padding(horizontal = 12.dp),
                tint = Color.White
            )
            Icon(
                Icons.Rounded.Search,
                contentDescription = "Watchlist",
                modifier = Modifier.padding(horizontal = 12.dp),
                tint = Color.White
            )
        }, title = { Text(text = "Portfolio") }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF003366),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ), navigationIcon = {
            Icon(
                Icons.Rounded.Person,
                contentDescription = "Watchlist",
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        })
    }) { contentPadding ->
        Box(Modifier.padding(contentPadding)) {
            StockList(data)
        }
    }
}