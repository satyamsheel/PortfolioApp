package com.example.portfoliodesign.domain.feature.portfolio.repository

import com.example.portfoliodesign.data.localDB.UserHoldingModel
import com.example.portfoliodesign.domain.ResourceData
import kotlinx.coroutines.flow.Flow

interface UserHoldingRepository {
    fun getUserHoldings(): Flow<ResourceData<List<UserHoldingModel>?>>
}
