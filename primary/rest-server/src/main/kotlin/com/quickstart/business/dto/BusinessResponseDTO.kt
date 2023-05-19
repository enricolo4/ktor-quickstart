package com.quickstart.business.dto

import com.quickstart.business.model.Business
import kotlinx.serialization.Serializable

@Serializable
internal data class BusinessResponseDTO(
    val id: String,
    val tradeName: String,
    val nationalRegistration: String
)

internal fun Business.toDTO() = BusinessResponseDTO(
    id = id!!.toString(),
    tradeName = tradeName,
    nationalRegistration = nationalRegistration
)
