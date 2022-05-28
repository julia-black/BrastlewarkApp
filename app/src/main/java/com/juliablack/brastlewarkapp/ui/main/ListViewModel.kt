package com.juliablack.brastlewarkapp.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.juliablack.data.repository.BrastlewarkRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(private val repository: BrastlewarkRepository) : ViewModel() {

    fun getInhabitants() {
        repository.getInhabitants()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("LOG", it.toString())
            }, {
                Log.d("LOG", it.toString())
            })
    }
}