package com.example.cypherx_firstproblem

import retrofit2.Response
import javax.inject.Inject

class Repo (
    private val retrofitService: RetrofitService
) {
    suspend fun postData(post:CypherXPostModel):Response<CypherXPostModel> {
        return retrofitService.postData(post)
    }

}
