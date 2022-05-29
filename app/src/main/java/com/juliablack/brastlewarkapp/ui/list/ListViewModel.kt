package com.juliablack.brastlewarkapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juliablack.domain.GetInhabitantsUseCase
import com.juliablack.domain.model.Gender
import com.juliablack.domain.model.Inhabitant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(
    private val getInhabitantsUseCase: GetInhabitantsUseCase
) : ViewModel() {

    val liveInhabitants = MutableLiveData<List<Inhabitant>>()
    val liveError = MutableLiveData<String>()

    private var loadedInhabitants: List<Inhabitant>? = null
    private var query = ""

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
        this.query = query
        if (query.isNotBlank()) {
            liveInhabitants.postValue(filter(loadedInhabitants, query))
        } else {
            loadedInhabitants?.let {
                liveInhabitants.postValue(it)
            }
        }
    }

    fun onClickGender(gender: Gender? = null) {
        liveInhabitants.postValue(filterByGender(gender))
    }

    private fun filter(list: List<Inhabitant>?, query: String) = list?.filter {
        it.name.lowercase().contains(query.lowercase())
    }

    private fun filterByGender(gender: Gender?): List<Inhabitant>? {
        return if (gender == null) {
            filter(loadedInhabitants, query)
        } else {
            filter(loadedInhabitants?.filter {
                it.gender == gender
            }, query)
        }
    }
}