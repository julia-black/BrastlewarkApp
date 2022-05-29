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

    private var loadedInhabitants: List<Inhabitant>? = null

    init {
        getInhabitants()
    }

    fun getInhabitants() {
        getInhabitantsUseCase.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadedInhabitants = it
                liveInhabitants.postValue(it)
            }, {
                liveError.postValue(it.message)
            })
    }

    fun onQuerySearchChange(query: String) {
        if (query.isNotBlank()) {
            liveInhabitants.postValue(filter(query))
        } else {
            loadedInhabitants?.let {
                liveInhabitants.postValue(it)
            }
        }
    }

    private fun filter(query: String) = loadedInhabitants?.filter {
        it.name.lowercase().contains(query.lowercase())
    }
}