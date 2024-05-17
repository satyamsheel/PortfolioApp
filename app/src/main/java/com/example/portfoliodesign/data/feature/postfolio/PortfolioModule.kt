package com.example.portfoliodesign.data.feature.postfolio

import com.example.portfoliodesign.domain.feature.portfolio.repository.UserHoldingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PortfolioModule {

    @Binds
    abstract fun bindUserHoldingRepository(userHoldingRepositoryImp: UserHoldingRepoImpL): UserHoldingRepository
}