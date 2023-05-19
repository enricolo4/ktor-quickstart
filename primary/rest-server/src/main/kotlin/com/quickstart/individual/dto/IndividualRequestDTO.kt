package com.quickstart.individual.dto

import com.quickstart.individual.model.IndividualRequest
import kotlinx.serialization.Serializable

@Serializable
internal data class IndividualRequestDTO(
    val name: String,
    val nationalRegistration:String
) {
    fun toModel() = IndividualRequest(
        name = name,
        nationalRegistration = nationalRegistration
    )
}
