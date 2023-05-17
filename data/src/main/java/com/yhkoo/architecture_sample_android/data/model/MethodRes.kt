package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.BaseResponse
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.Method

data class MethodRes(
    @SerializedName("mash_temp")
    val mashTemp: List<MashTempRes>? = null,
    @SerializedName("fermentation")
    val fermentation: FermentationRes? = null
) : BaseResponse {
    companion object : DataMapper<MethodRes, Method> {
        override fun toDataModel(response: MethodRes): Method {
            return Method(
                mashTemp = response.mashTemp?.map {
                    MashTempRes.toDataModel(it)
                },
                fermentation = response.fermentation?.let { res ->
                    FermentationRes.toDataModel(res)
                }
            )
        }
    }
}