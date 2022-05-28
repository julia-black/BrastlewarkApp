package com.juliablack.brastlewarkapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juliablack.domain.GetInhabitantsUseCase
import com.juliablack.domain.model.Inhabitant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(
    private val getInhabitantsUseCase: GetInhabitantsUseCase
) : ViewModel() {

    val liveInhabitants = MutableLiveData<List<Inhabitant>>()
    val liveError = MutableLiveData<String>()

    init {
        getInhabitants()
    }

    fun getInhabitants() {
        getInhabitantsUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveInhabitants.postValue(it)
            }, {
                liveError.postValue(it.message)
            })
    }
}