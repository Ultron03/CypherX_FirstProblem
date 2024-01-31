package com.example.cypherx_firstproblem

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var postViewModel: ViewModel
    private lateinit var postViewModelFactory: ViewModelFactory
    private lateinit var  repo: Repo

    private lateinit var btnPost:Button
    private lateinit var btnStopPost:Button
    private lateinit var jobScheduler: JobScheduler
    private lateinit var postJobService: PostJobService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
//        val post = CypherXPostModel(battery_status = "90", free_bytes = 2, last_chunk_download_time = "Random", network_speed_ = 2, used_bandwidth = 2)
//        postViewModel.postData(post)
//        postViewModel.postLiveData.observe(this, Observer {response->
//            if (response.isSuccessful){
//                Log.i("MainActivity",response.body().toString())
//            }
//            else{
//                Toast.makeText(this,"Not Happing",Toast.LENGTH_SHORT).show()
//            }
//        })
//        PostJobService(postViewModel)

//        PostJobService()


        btnPost.setOnClickListener {
            startSendingRequest()
        }
        btnStopPost.setOnClickListener {
            stopSendingRequest()
        }

    }

    private fun stopSendingRequest() {
        jobScheduler.cancel(101)
        Log.i("PostJob","Job Stopped")
    }

    private fun startSendingRequest() {
        val componentName = ComponentName(this,PostJobService::class.java)
        val jobInfo= JobInfo.Builder(101,componentName)
            .setPeriodic(15*60*1000)
            .setRequiresCharging(false)
            .build()
        if (jobScheduler.schedule(jobInfo)==JobScheduler.RESULT_SUCCESS){
            Log.i("PostJob","Successfull")
        }
    }

    private fun init(){
        repo = Repo(RetrofitBuilder.getInstance())
        postViewModelFactory = ViewModelFactory(repo)
        postViewModel = ViewModelProvider(this,postViewModelFactory).get(ViewModel::class.java)

        btnPost = findViewById(R.id.btn_postData)
        btnStopPost = findViewById(R.id.btn_stoppostData)

        jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
    }

}