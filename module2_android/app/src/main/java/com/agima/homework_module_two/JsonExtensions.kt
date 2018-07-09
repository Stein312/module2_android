/*
 * Copyright © 2018 AGIMA Education. All rights reserved.
 * Created by Alexander Tizik on 01/06/2018
 */

package com.agima.homework_module_two

import org.json.JSONArray
import org.json.JSONObject

fun JSONArray.toList() = (0 until length()).map { get(it) as JSONObject }