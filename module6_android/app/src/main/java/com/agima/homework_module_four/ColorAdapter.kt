/*
 * Copyright © 2018 AGIMA Education. All rights reserved.
 * Created by Alexander Tizik on 01/06/2018
 */

package com.agima.homework_module_four

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import com.agima.homework_module_six.R
import kotlinx.android.synthetic.main.simple_text.view.*
import java.io.Serializable

data class Color(val color: String,
                 val value: String): Serializable


class ColorAdapter(context: Context, @LayoutRes id: Int, private val color: List<Color>) : ArrayAdapter<Color>(context, id) {

    override fun getCount(): Int = color.size

    override fun getItem(position: Int): Color =
            color[position+1]

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row = LayoutInflater.from(context).inflate(R.layout.simple_text, parent, false)

        row.title.text = getItem(position).color
        row.subtitle.text = getItem(position).value

        return row
    }

}