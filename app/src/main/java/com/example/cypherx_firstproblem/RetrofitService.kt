package com.example.cypherx_firstproblem

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("register")
    suspend fun postData(
        @Body post:CypherXPostModel
    ):Response<CypherXPostModel>
}