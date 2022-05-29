package com.juliablack.domain.model

import com.juliablack.data.model.InhabitantResponse

class Inhabitant(
    val id: Int,
    val name: String,
    val thumbnail: String
)

fun InhabitantResponse.fromResponse() = Inhabitant(id, name, thumbnail)