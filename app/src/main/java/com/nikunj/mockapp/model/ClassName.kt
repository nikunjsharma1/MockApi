package com.nikunj.mockapp.model

import com.google.gson.annotations.SerializedName

data class ClassName(
    @SerializedName("associatedDrug")
    val DrugFirst: List<AssociatedDrug>,
    @SerializedName("associatedDrug#2")
    val DrugSecond: List<AssociatedDrug2>
)
