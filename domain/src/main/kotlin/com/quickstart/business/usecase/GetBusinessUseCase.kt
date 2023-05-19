package com.quickstart.business.usecase

import com.quickstart.business.ports.primary.GetBusinessPort
import com.quickstart.business.ports.secondary.BusinessDataAccessPort
import java.util.UUID

class GetBusinessUseCase(
    private val businessDataAccessPort: BusinessDataAccessPort
) : GetBusinessPort {
    override suspend fun getById(id: UUID) = businessDataAccessPort.findById(id)
}
