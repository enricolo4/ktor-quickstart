package com.quickstart.individual.ports.secondary

import com.quickstart.individual.model.Individual
import java.util.UUID

interface IndividualDataAccessPort {
    suspend fun save(individual: Individual): Individual
    suspend fun findById(id: UUID): Individual?
}
