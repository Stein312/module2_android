/*
 * Copyright © 2018 AGIMA Education. All rights reserved.
 * Created by Alexander Tizik on 01/06/2018
 */

package com.agima.homework_module_four

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import android.content.ComponentName



class DetailActivity : AppCompatActivity() {
    companion object {
        const val extrasTag = "color"
        val contextList = mutableListOf<Context>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val color = (intent.getSerializableExtra(extrasTag) as Color)
        detailColor.text = "Selected color: ${color.value}:${color.color}"
        contextList+=this
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(JobInfo.Builder(0,
                ComponentName(this, MyJobService::class.java))
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build())
    }

    override fun onDestroy() {
        super.onDestroy()
        contextList.clear()
    }
}
