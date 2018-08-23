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
import android.widget.Toast
import com.agima.homework_module_six.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        send.setOnClickListener {
            auth()
        }
    }


    private fun auth() {
        RetrofitClient.retrofit.auth().enqueue(object : Callback<AuthResponse> {
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {

                val error = response.errorBody()?.string()
                if(error.isNullOrBlank()) {
                    sendForm(response.body()?.refresh_token ?: return)
                } else {
                    Toast.makeText(this@DetailActivity, error, Toast.LENGTH_SHORT).show()
                }
            }


        })
    }

    private fun sendForm(accessToken: String) {
        RetrofitClient.retrofit.message(
                FormRequest(
                        accessToken,
                        nameEd.text.toString(),
                        surnameEd.text.toString(),
                        messageEd.text.toString() + "\nSent from Skillbox Agima Ed Application!"
                )
        ).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                val error = response.errorBody()?.string()
                if(error.isNullOrBlank().not()) {
                    Toast.makeText(this@DetailActivity, error, Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

}
