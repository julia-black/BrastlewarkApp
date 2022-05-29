package com.juliablack.data.model

import com.google.gson.annotations.SerializedName

data class InhabitantResponse(
    val id: Int,
    val name: String,
    val thumbnail: String,
    val age: Int,
    val weight: Float,
    val height: Float,
    @SerializedName("hair_color")
    val hairColor: String,
    val professions: List<String>,
    val friends: List<String>
)