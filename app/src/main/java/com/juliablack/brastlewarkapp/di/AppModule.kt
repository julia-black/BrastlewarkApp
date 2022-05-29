package com.juliablack.brastlewarkapp.di

import com.juliablack.brastlewarkapp.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListViewModel(get(), get(), get()) }
}