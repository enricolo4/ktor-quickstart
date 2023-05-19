package com.quickstart.business.ports.primary

import com.quickstart.business.model.Business
import com.quickstart.business.model.BusinessRequest

interface CreateBusinessPort {
    suspend operator fun invoke(businessRequest: BusinessRequest): Business
}
