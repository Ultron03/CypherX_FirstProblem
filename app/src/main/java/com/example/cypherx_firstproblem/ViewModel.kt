package com.example.cypherx_firstproblem

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ViewModel
    (
    private val repo: Repo
):ViewModel() {


    val postLiveData = MutableLiveData<Response<CypherXPostModel>>()
    fun postData(post:CypherXPostModel){
        viewModelScope.launch() {
            Log.i("Nacho",post.toString())
            val response = repo.postData(post)
            Log.i("Nacho1",response.code().toString())
            Log.i("Nacho1",response.body().toString())
            postLiveData.value = response
        }
    }
}