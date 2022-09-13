package com.example.androidhiltapp.data.model

data class SampleResponse (
    val _id: String? = null,

    val content: String? = null,
    val author: String? = null,
    val tags: List<String>? = null,
    val authorSlug: String? = null,
    val length: Long? = null,
    val dateAdded: String? = null,
    val dateModified: String? = null
)