package com.example.portfoliodesign.data.feature.postfolio

import com.example.portfoliodesign.domain.feature.portfolio.repository.UserHoldingRepository
import com.example.portfoliodesign.data.localDB.UserHoldingDao
import com.example.portfoliodesign.data.localDB.UserHoldingModel
import com.example.portfoliodesign.domain.ResourceData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class UserHoldingRepoImpL @Inject constructor(
    private val apiService: ApiService,
    private val userHoldingDao: UserHoldingDao,
) : UserHoldingRepository {
    override fun getUserHoldings(): Flow<ResourceData<List<UserHoldingModel>?>> = flow {
        try {
            val response = apiService.getUserHoldings()
            val holdings: List<UserHoldingModel>? =
                response.body()?.data?.userHolding?.map { it.toUserHoldingModel() }
            userHoldingDao.deleteAll()
            if (!holdings.isNullOrEmpty())
                userHoldingDao.insertAll(holdings)
            emit(ResourceData.Success(holdings))
        } catch (e: Exception) {
            val localData = userHoldingDao.getAllHoldings().first()
            if (localData.isNotEmpty())
                emit(ResourceData.Success(localData))
            else
                emit(ResourceData.Error(e.message))
        }
    }
}

