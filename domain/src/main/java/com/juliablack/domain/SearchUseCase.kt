package com.juliablack.domain

import com.juliablack.domain.model.Inhabitant

class SearchUseCase {
    fun invoke(list: List<Inhabitant>?, query: String) = list?.filter {
        it.name.lowercase().contains(query.lowercase())
    }
}