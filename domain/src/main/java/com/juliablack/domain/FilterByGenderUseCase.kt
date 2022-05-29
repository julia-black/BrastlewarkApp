package com.juliablack.domain

import com.juliablack.domain.model.Gender
import com.juliablack.domain.model.Inhabitant

class FilterByGenderUseCase {
    fun invoke(list: List<Inhabitant>, gender: Gender?) =
        if (gender == null) list else list.filter { it.gender == gender }
}