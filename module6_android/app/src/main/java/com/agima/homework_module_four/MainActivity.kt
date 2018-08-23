/*
 * Copyright © 2018 AGIMA Education. All rights reserved.
 * Created by Alexander Tizik on 01/06/2018
 */

package com.agima.homework_module_four

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agima.homework_module_six.R
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val colors = application.assets.open("data.json").bufferedReader().use {
            it.readText()
        }


        val jsonArray = JSONArray(colors)
        val colorsList = jsonArray.toList().map { Color(it.getString("color"),it.getString("value")) }

        list.adapter = ColorAdapter(this, R.layout.simple_text,colorsList)

        list.setOnItemClickListener { _, _, _, _ ->

            val intent = Intent(this,DetailActivity::class.java)

            startActivity(intent)
        }




    }
}




