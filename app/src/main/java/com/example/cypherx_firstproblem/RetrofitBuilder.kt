package com.example.cypherx_firstproblem

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitBuilder {

    companion object{
        var retrofitService:RetrofitService? = null
        fun getInstance():RetrofitService{
            if(retrofitService==null){
                retrofitService = Retrofit.Builder()
                    .baseUrl("https://cloud.cypherx.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create()
            }
            return retrofitService!!
        }
    }
}