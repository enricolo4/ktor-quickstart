package com.quickstart.business.ports.primary

import com.quickstart.business.model.Business
import java.util.UUID

interface GetBusinessPort {
    suspend fun getById(id: UUID): Business?
}
