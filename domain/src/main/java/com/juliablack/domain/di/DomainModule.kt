package com.juliablack.domain.di

import com.juliablack.domain.FilterByGenderUseCase
import com.juliablack.domain.GetInhabitantsUseCase
import com.juliablack.domain.SearchUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetInhabitantsUseCase(get()) }
    single { SearchUseCase() }
    single { FilterByGenderUseCase() }
}