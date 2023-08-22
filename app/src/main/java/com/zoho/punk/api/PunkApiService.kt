package com.zoho.punk.api

import com.zoho.punk.Beer
import retrofit2.http.GET

interface PunkApiService {
        @GET("/beers")
        suspend fun getBeers(): List<Beer>
    }
