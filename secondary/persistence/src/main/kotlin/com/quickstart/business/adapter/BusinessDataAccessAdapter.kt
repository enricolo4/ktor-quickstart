package com.quickstart.business.adapter

import com.quickstart.business.entity.toEntity
import com.quickstart.business.model.Business
import com.quickstart.business.ports.secondary.BusinessDataAccessPort
import com.quickstart.business.repository.BusinessRepository
import java.util.UUID

internal class BusinessDataAccessAdapter(
    private val businessRepository: BusinessRepository
) : BusinessDataAccessPort {
    override suspend fun save(business: Business) = businessRepository.save(business.toEntity()).toModel()

    override suspend fun findById(id: UUID) = businessRepository.findById(id)?.toModel()
}
