package com.juliablack.brastlewarkapp.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juliablack.data.model.InhabitantResponse
import com.juliablack.data.repository.BrastlewarkRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(private val repository: BrastlewarkRepository) : ViewModel() {

    val liveInhabitants = MutableLiveData<List<InhabitantResponse>>()

    fun getInhabitants() {
        repository.getInhabitants()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveInhabitants.value = it.brastlewark
            }, {
                Log.d("LOG", it.toString())
            })
    }
}