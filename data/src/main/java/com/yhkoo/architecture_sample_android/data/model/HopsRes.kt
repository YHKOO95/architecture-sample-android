package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName

data class HopsRes(
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: String,
    @SerializedName("add")
    val add: String,
    @SerializedName("attribute")
    val attribute: String
) : ValueRes()