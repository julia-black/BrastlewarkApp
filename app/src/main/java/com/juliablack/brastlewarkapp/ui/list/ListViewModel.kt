package com.juliablack.brastlewarkapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juliablack.domain.FilterByGenderUseCase
import com.juliablack.domain.GetInhabitantsUseCase
import com.juliablack.domain.SearchUseCase
import com.juliablack.domain.model.Gender
import com.juliablack.domain.model.Inhabitant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(
    private val getInhabitantsUseCase: GetInhabitantsUseCase,
    private val searchUseCase: SearchUseCase,
    private val filterByGenderUseCase: FilterByGenderUseCase
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
        loadedInhabitants?.let {
            liveInhabitants.postValue(filterByGender(it, gender))
        }
    }

    private fun filter(list: List<Inhabitant>?, query: String) = searchUseCase.invoke(list, query)

    private fun filterByGender(list: List<Inhabitant>, gender: Gender?) =
        searchUseCase.invoke(filterByGenderUseCase.invoke(list, gender), query)
}