package com.quickstart.individual.usecase

import com.quickstart.individual.ports.primary.GetIndividualPort
import com.quickstart.individual.ports.secondary.IndividualDataAccessPort
import java.util.UUID

class GetIndividualUseCase(
    private val individualDataAccessPort: IndividualDataAccessPort
) : GetIndividualPort {
    override suspend fun getById(id: UUID) = individualDataAccessPort.findById(id)
}
