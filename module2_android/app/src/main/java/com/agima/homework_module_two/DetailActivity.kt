/*
 * Copyright © 2018 AGIMA Education. All rights reserved.
 * Created by Alexander Tizik on 01/06/2018
 */

package com.agima.homework_module_two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val extrasTag = "color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val color = (intent.getSerializableExtra(extrasTag) as Color)
        detailColor.text = "Selected color: ${color.value}:${color.color}"
    }
}
