package com.example.portfoliodesign.presentation.feature.portfolio.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliodesign.data.localDB.UserHoldingModel
import com.example.portfoliodesign.presentation.feature.portfolio.ui.roundOffDecimal

@Composable
fun StockItemRow(stockItem: UserHoldingModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                stockItem.symbol,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.W600
            )
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            val quantityText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFFaab5bf))) {
                    append("Net Qty: ")
                }
                withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                    append(" ${stockItem.quantity}")
                }
            }
            Text(text = quantityText)
        }

        Column(horizontalAlignment = Alignment.End) {

            val ltpText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFFaab5bf))) {
                    append("LTP: ")
                }
                withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                    append(" ${stockItem.ltp}")
                }
            }
            Text(text = ltpText)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            val profitAndLossText = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 12.sp, color = Color(0xFFaab5bf))) {
                    append("P&L: ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (stockItem.ltp - stockItem.avgPrice >= 0) Color(0xFF5dc198) else Color(0xFFf04f59)
                    )
                ) {
                    append(" ${((stockItem.ltp - stockItem.avgPrice) * stockItem.quantity).roundOffDecimal()}")
                }
            }
            Text(text = profitAndLossText)
        }
    }
}