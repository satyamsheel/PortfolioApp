package com.example.portfoliodesign.presentation.feature.portfolio.state

import com.example.portfoliodesign.data.localDB.UserHoldingModel

data class UserHoldingUiState(
    val userClassModel: List<UserHoldingModel>? = null,
    var portfolioState: PortfolioState? = null,
)