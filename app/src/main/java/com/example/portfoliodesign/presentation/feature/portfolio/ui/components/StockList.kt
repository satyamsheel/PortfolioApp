package com.example.portfoliodesign.presentation.feature.portfolio.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.portfoliodesign.presentation.feature.portfolio.state.UserHoldingUiState

@Composable
fun StockList(stockItems: UserHoldingUiState) {
    stockItems.apply {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 55.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                userClassModel?.forEach { item ->
                    StockItemRow(item)
                    Divider(color = Color.Gray, thickness = (0.5).dp)
                }
            }
            CollapsibleCard(portfolioState, Modifier.align(Alignment.BottomEnd))
        }
    }
}