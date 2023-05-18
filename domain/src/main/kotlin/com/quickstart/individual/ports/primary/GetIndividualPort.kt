package com.quickstart.individual.ports.primary

import com.quickstart.individual.model.Individual
import java.util.UUID

interface GetIndividualPort {
    suspend fun getById(id: UUID): Individual?
}
