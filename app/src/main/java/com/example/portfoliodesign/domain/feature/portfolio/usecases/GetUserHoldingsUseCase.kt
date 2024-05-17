package com.example.portfoliodesign.domain.feature.portfolio.usecases

import com.example.portfoliodesign.domain.feature.portfolio.repository.UserHoldingRepository
import com.example.portfoliodesign.data.localDB.UserHoldingModel
import com.example.portfoliodesign.domain.ResourceData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserHoldingsUseCase @Inject constructor(private val repository: UserHoldingRepository) {
    fun userHoldingUseCase(): Flow<ResourceData<List<UserHoldingModel>?>>{
        return repository.getUserHoldings()
    }
}