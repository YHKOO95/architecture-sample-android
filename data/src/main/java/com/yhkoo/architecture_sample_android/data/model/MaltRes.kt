package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.BaseResponse
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.Malt

data class MaltRes(
    @SerializedName("name")
    val name: String,
    @SerializedName("amount")
    val amount: String
) : BaseResponse {
    companion object : DataMapper<MaltRes, Malt> {
        override fun toDataModel(response: MaltRes): Malt {
            return Malt(
                name = response.name,
                amount = response.amount
            )
        }
    }
}