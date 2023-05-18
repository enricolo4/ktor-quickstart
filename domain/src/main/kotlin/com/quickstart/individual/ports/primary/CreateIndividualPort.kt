package com.quickstart.individual.ports.primary

import com.quickstart.individual.model.Individual
import com.quickstart.individual.model.IndividualRequest

interface CreateIndividualPort {
    suspend operator fun invoke(individualRequest: IndividualRequest): Individual
}
