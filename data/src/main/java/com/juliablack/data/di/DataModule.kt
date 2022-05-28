package com.juliablack.data.di

import com.juliablack.data.network.createApi
import com.juliablack.data.repository.BrastlewarkRepository
import org.koin.dsl.module

val dataModule = module {
    single { BrastlewarkRepository(createApi()) }
}