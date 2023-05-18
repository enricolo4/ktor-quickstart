package com.quickstart.individual.usecase

import com.quickstart.individual.model.IndividualRequest
import com.quickstart.individual.ports.primary.CreateIndividualPort
import com.quickstart.individual.ports.secondary.IndividualDataAccessPort

class CreateIndividualUseCase(
    private val individualDataAccessPort: IndividualDataAccessPort
) : CreateIndividualPort {
    override suspend fun invoke(individualRequest: IndividualRequest) =
        individualDataAccessPort.save(individualRequest.toModel())
}
