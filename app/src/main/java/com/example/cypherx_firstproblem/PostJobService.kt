package com.example.cypherx_firstproblem

import android.app.job.JobParameters
import android.app.job.JobService

class PostJobService(
) :JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {
        startRequest()
        return true
    }

    private fun startRequest(){
        val post = CypherXPostModel(battery_status = "90", free_bytes = 2, last_chunk_download_time = "Random", network_speed_ = 2, used_bandwidth = 2)
        ViewModel(Repo(RetrofitBuilder.getInstance())).postData(post)
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        return true
    }
}