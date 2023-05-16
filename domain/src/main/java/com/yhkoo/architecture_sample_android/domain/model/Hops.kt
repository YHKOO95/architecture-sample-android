package com.yhkoo.architecture_sample_android.domain.model

data class Hops(
    val name: String,
    val amount: String,
    val add: String,
    val attribute: String
) : Value()