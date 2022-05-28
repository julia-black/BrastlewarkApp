package com.juliablack.domain.model

import com.juliablack.data.model.InhabitantResponse

class Inhabitant(
    val id: Int,
    val name: String
)

fun InhabitantResponse.fromResponse() = Inhabitant(id, name)