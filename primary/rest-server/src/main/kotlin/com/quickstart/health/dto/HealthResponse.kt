package com.quickstart.health.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestHealthResponse(
    @SerialName(value = "status")
    val status: String,
    @SerialName(value = "version")
    val version: String,
    @SerialName(value = "remoteService")
    val remoteService: String? = null,
    @SerialName(value = "database")
    val database: String? = null
)
