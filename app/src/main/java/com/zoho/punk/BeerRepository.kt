package com.zoho.punk

import com.zoho.punk.api.PunkApiService
import com.zoho.punk.api.RetrofitClient

class BeerRepository {
    private val apiService: PunkApiService = RetrofitClient.create()

    suspend fun getBeers(): List<Beer> {
        return apiService.getBeers()
    }
}