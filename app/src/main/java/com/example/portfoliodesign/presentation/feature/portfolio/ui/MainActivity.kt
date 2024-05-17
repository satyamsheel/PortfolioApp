package com.example.portfoliodesign.presentation.feature.portfolio.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.portfoliodesign.presentation.ResourceUI
import com.example.portfoliodesign.presentation.feature.portfolio.UserHoldingViewModel
import com.example.portfoliodesign.presentation.feature.portfolio.state.UserHoldingUiState
import com.example.portfoliodesign.presentation.feature.portfolio.ui.components.ErrorWidget
import com.example.portfoliodesign.presentation.feature.portfolio.ui.components.LoadingWidget
import com.example.portfoliodesign.presentation.feature.portfolio.ui.components.UserHoldingsScreen
import com.example.portfoliodesign.ui.theme.PortfolioDesignTheme
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioDesignTheme {
                val viewModel by viewModels<UserHoldingViewModel>()
                val uiState by viewModel.userHoldings.collectAsState()
                when (uiState) {
                    ResourceUI.Loading -> LoadingWidget()
                    is ResourceUI.Error -> ErrorWidget(
                        (uiState as ResourceUI.Error).message,
                        viewModel::fetchData
                    )
                    is ResourceUI.Success -> UserHoldingsScreen((uiState as ResourceUI.Success<UserHoldingUiState>).data)
                }
            }
        }
    }
}

fun Double.roundOffDecimal(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
    return format.format(this)
}

