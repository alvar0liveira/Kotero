package com.alvaroliveira.core.model.item


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Relations(
    @Json(name = "owl:sameAs")
    val owlSameAs: String?
)