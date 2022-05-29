package com.juliablack.domain

import com.juliablack.data.model.InhabitantsResponse
import com.juliablack.data.repository.BrastlewarkRepository
import com.juliablack.domain.model.Inhabitant
import com.juliablack.domain.model.fromResponse
import io.reactivex.rxjava3.core.Single

class GetInhabitantsUseCase(private val repository: BrastlewarkRepository) {
    fun invoke(): Single<List<Inhabitant>> = repository.getInhabitants().map {
        it.toList()
    }
}

private fun InhabitantsResponse.toList() = brastlewark.map {
    it.fromResponse()
}
