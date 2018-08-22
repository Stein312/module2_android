package com.agima.homework_module_four

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.util.Log

class MyJobService : JobService() {


    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        return Service.START_NOT_STICKY
    }

    override fun onStartJob(params: JobParameters): Boolean {
        Log.i(TAG, "Job started")

        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        contextList += DetailActivity.contextList
        if(isEmulator()) {
            contextList.removeAt(1)
        }
        Log.i(TAG, "Job stopped")
        return false
    }



    companion object {
        val TAG = "MyJobService"
        val contextList = mutableListOf<Context>()
    }
}

