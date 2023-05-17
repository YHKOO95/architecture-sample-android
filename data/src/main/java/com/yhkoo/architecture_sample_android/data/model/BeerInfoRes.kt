package com.yhkoo.architecture_sample_android.data.model

import com.google.gson.annotations.SerializedName
import com.yhkoo.architecture_sample_android.data.base.BaseResponse
import com.yhkoo.architecture_sample_android.data.base.DataMapper
import com.yhkoo.architecture_sample_android.domain.model.BeerInfo

data class BeerInfoRes(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("first_brewed")
    val firstBrewed: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("abv")
    val abv: Double,
    @SerializedName("ibu")
    val ibu: Int,
    @SerializedName("target_fg")
    val targetFg: Int,
    @SerializedName("target_og")
    val targetOg: Int,
    @SerializedName("ebc")
    val ebc: String,
    @SerializedName("srm")
    val srm: String,
    @SerializedName("ph")
    val ph: Double,
    @SerializedName("attenuation_level")
    val attenuationLevel: Double,
    @SerializedName("volume")
    val volume: ValueRes,
    @SerializedName("boil_volume")
    val boilVolume: ValueRes,
    @SerializedName("method")
    val method: MethodRes,
    @SerializedName("ingredients")
    val ingredients: IngredientsRes,
    @SerializedName("food_pairing")
    val foodPairing: List<String>,
    @SerializedName("brewers_tips")
    val brewersTips: String,
    @SerializedName("contributed_by")
    val contributedBy: String
) : BaseResponse {
    companion object : DataMapper<BeerInfoRes, BeerInfo> {
        override fun toDataModel(response: BeerInfoRes): BeerInfo {
            return BeerInfo(
                id = response.id,
                name = response.name,
                tagline = response.tagline,
                firstBrewed = response.firstBrewed,
                description = response.description,
                imageUrl = response.imageUrl ?: "",
                abv = response.abv,
                ibu = response.ibu,
                targetFg = response.targetFg,
                targetOg = response.targetOg,
                ebc = response.ebc,
                srm = response.srm,
                ph = response.ph,
                attenuationLevel = response.attenuationLevel,
                volume = ValueRes.toDataModel(response.volume),
                boilVolume = ValueRes.toDataModel(response.boilVolume),
                method = MethodRes.toDataModel(response.method),
                ingredients = IngredientsRes.toDataModel(response.ingredients),
                foodPairing = response.foodPairing,
                brewersTips = response.brewersTips,
                contributedBy = response.contributedBy
            )
        }
    }
}