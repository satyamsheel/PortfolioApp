package com.example.portfoliodesign.presentation.feature.portfolio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.portfoliodesign.data.localDB.UserHoldingModel
import com.example.portfoliodesign.domain.ResourceData
import com.example.portfoliodesign.domain.feature.portfolio.usecases.GetUserHoldingsUseCase
import com.example.portfoliodesign.presentation.ResourceUI
import com.example.portfoliodesign.presentation.feature.portfolio.state.PortfolioState
import com.example.portfoliodesign.presentation.feature.portfolio.state.UserHoldingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserHoldingViewModel @Inject constructor(private val useCase: GetUserHoldingsUseCase) :
    ViewModel() {


    private val _userHoldings = MutableStateFlow<ResourceUI<UserHoldingUiState>>(ResourceUI.Loading)
    val userHoldings: StateFlow<ResourceUI<UserHoldingUiState>> get() = _userHoldings

    init {
        fetchData()
    }

    fun fetchData() {

        viewModelScope.launch(Dispatchers.IO) {
            _userHoldings.value = ResourceUI.Loading
            useCase.userHoldingUseCase().collect { userHoldings ->
                when(userHoldings){
                    is ResourceData.Error -> _userHoldings.emit(ResourceUI.Error(userHoldings.message))
                    is ResourceData.Success -> {
                        if (!userHoldings.data.isNullOrEmpty()) {
                            _userHoldings.value =
                                ResourceUI.Success(UserHoldingUiState(userClassModel = userHoldings.data))
                            withContext(Dispatchers.Default) {
                                _userHoldings.update {
                                    val data =
                                        (_userHoldings.value as ResourceUI.Success<UserHoldingUiState>).data
                                    data.portfolioState = calculatePortfolioState(data.userClassModel!!)

                                    ResourceUI.Success(data = data)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun calculatePortfolioState(portfolio: List<UserHoldingModel>): PortfolioState {
        val totalInvestment = portfolio.sumOf { it.quantity * it.avgPrice }
        val currentValue = portfolio.sumOf { it.quantity * it.ltp }
        val totalProfitLoss = currentValue - totalInvestment

        val yesterdayTotalValue = portfolio.sumOf { it.quantity * it.close }
        val todayProfitLoss = currentValue - yesterdayTotalValue

        return PortfolioState(
            totalInvestment = totalInvestment,
            currentValue = currentValue,
            totalProfitLoss = totalProfitLoss,
            todayProfitLoss = todayProfitLoss
        )
    }
}
