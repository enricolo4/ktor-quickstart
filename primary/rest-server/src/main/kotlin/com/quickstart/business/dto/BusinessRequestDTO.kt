package com.quickstart.business.dto

import com.quickstart.business.model.BusinessRequest
import kotlinx.serialization.Serializable

@Serializable
internal data class BusinessRequestDTO(
    val tradeName: String,
    val nationalRegistration: String
) {
    fun toModel() = BusinessRequest(tradeName = tradeName, nationalRegistration = nationalRegistration)
}
