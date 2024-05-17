package com.example.portfoliodesign.data.feature.postfolio

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    suspend fun getUserHoldings(): Response<DataResponse>
}