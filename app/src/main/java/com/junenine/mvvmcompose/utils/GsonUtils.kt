package com.junenine.mvvmcompose.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder


object GsonUtils {
    var gson: Gson = GsonBuilder().create()

    fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }

    fun fromJson(json: String, clazz: Class<*>): Any {
        return gson.fromJson(json, clazz)
    }
}