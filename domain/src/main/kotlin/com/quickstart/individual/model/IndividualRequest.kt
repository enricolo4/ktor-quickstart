package com.quickstart.individual.model

data class IndividualRequest(
    val name: String,
    val nationalRegistration: String
) {
    fun toIndividual() = Individual(
        name = name,
        nationalRegistration = nationalRegistration
    )
}
