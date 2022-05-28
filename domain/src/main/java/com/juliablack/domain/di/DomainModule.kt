package com.juliablack.domain.di

import com.juliablack.domain.GetInhabitantsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetInhabitantsUseCase(get()) }
}