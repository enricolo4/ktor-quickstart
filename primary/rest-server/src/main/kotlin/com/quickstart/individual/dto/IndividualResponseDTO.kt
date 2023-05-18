package com.quickstart.individual.dto

import com.quickstart.individual.model.Individual
import kotlinx.serialization.Serializable

@Serializable
data class IndividualResponseDTO(
    val id: String,
    val name: String,
    val nationalRegistration: String
)

fun Individual.toDTO() = IndividualResponseDTO(
    id = id!!.toString(),
    name = name,
    nationalRegistration = nationalRegistration
)
