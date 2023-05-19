package com.quickstart.business.usecase

import com.quickstart.business.model.Business
import com.quickstart.business.model.BusinessRequest
import com.quickstart.business.ports.primary.CreateBusinessPort
import com.quickstart.business.ports.secondary.BusinessDataAccessPort

class CreateBusinessUseCase(
    private val businessDataAccessPort: BusinessDataAccessPort
) : CreateBusinessPort {
    override suspend fun invoke(businessRequest: BusinessRequest) = businessDataAccessPort.save(businessRequest.toBusiness())
}
