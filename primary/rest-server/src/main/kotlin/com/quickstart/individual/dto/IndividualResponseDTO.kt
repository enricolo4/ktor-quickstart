package com.quickstart.individual.dto

import com.quickstart.individual.model.Individual
import kotlinx.serialization.Serializable

@Serializable
internal data class IndividualResponseDTO(
    val id: String,
    val name: String,
    val nationalRegistration: String
)

internal fun Individual.toDTO() = IndividualResponseDTO(
    id = id!!.toString(),
    name = name,
    nationalRegistration = nationalRegistration
)
