package com.juliablack.data.model

import com.google.gson.annotations.SerializedName

data class InhabitantsResponse(
    @SerializedName("Brastlewark")
    val brastlewark: List<InhabitantResponse>
)