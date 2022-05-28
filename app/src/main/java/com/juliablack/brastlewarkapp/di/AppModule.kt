package com.juliablack.brastlewarkapp.di

import com.juliablack.brastlewarkapp.ui.main.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListViewModel(get()) }
}