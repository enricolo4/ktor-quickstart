package com.quickstart.business.model

data class BusinessRequest(
    val tradeName: String,
    val nationalRegistration: String
) {
    fun toBusiness() = Business(
        tradeName = tradeName,
        nationalRegistration = nationalRegistration
    )
}
