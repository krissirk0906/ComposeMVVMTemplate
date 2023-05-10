package com.junenine.mvvmcompose.utils

object Constants {
    const val TRANSACTION_DATABASE = "TRANSACTION_DATABASE"
    const val TRANSACTION_TABLE = "TRANSACTION_TABLE"

    const val NEED_REFRESH = "needRefresh"

    fun String.toCategory() : Int
    {
        return -1
    }

    fun List<String>.toEncodedString() : String
    {
        return ""
    }
}