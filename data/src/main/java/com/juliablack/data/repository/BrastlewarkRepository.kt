package com.juliablack.data.repository

import com.juliablack.data.network.Api

class BrastlewarkRepository(private val api: Api) {
    fun getInhabitants() = api.getInhabitants()
}