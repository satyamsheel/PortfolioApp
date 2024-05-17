package com.example.portfoliodesign.presentation.feature.portfolio.state

data class PortfolioState(
        val totalInvestment: Double,
        val currentValue: Double,
        val totalProfitLoss: Double,
        val todayProfitLoss: Double
    )