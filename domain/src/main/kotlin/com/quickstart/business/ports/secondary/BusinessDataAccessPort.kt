package com.quickstart.business.ports.secondary

import com.quickstart.business.model.Business
import java.util.UUID

interface BusinessDataAccessPort {
    suspend fun save(business: Business): Business
    suspend fun findById(id: UUID): Business?
}
