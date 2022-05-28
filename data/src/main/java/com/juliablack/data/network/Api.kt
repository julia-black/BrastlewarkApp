package com.juliablack.data.network

import com.juliablack.data.model.InhabitantsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface Api {
    @GET("/rrafols/mobile_test/master/data.json")
    fun getInhabitants(): Single<InhabitantsResponse>
}