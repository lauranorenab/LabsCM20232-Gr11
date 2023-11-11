package com.udea.spaceexplorer.infrastructure.retrofitService

import com.example.jetsnack.model.Snack
import retrofit2.http.GET

interface RetrofitService {
    @GET("jetsnack/snacks")
    suspend fun getSnacks(
    ) : List<Snack>
}