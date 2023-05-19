package com.quickstart.business.model

import java.util.UUID

data class Business(
    val id: UUID? = null,
    val tradeName: String,
    val nationalRegistration: String
)
