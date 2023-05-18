package com.quickstart.individual.adapter

import com.quickstart.individual.entity.toEntity
import com.quickstart.individual.model.Individual
import com.quickstart.individual.ports.secondary.IndividualDataAccessPort
import com.quickstart.individual.repository.IndividualRepository
import java.util.UUID

internal class IndividualDataAccessAdapter(
    private val individualRepository: IndividualRepository
) : IndividualDataAccessPort {

    override suspend fun save(individual: Individual) = individualRepository.save(individual.toEntity()).toModel()

    override suspend fun findById(id: UUID) = individualRepository.findById(id)?.toModel()
}
