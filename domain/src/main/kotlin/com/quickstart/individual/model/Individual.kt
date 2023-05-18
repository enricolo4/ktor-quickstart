package com.quickstart.individual.model

import java.util.UUID

data class Individual(
    val id: UUID? = null,
    val name: String,
    val nationalRegistration: String
)
