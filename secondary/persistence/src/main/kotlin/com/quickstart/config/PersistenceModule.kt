package com.quickstart.config

import com.quickstart.business.ports.secondary.BusinessDataAccessPort
import com.quickstart.individual.ports.secondary.IndividualDataAccessPort
import com.quickstart.individual.repository.IndividualRepository
import com.quickstart.individual.adapter.IndividualDataAccessAdapter
import com.quickstart.business.repository.BusinessRepository
import com.quickstart.business.adapter.BusinessDataAccessAdapter
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val persistenceModules = module {
    singleOf(::IndividualRepository)
    singleOf(::IndividualDataAccessAdapter) { bind<IndividualDataAccessPort>() }
    singleOf(::BusinessRepository)
    singleOf(::BusinessDataAccessAdapter) { bind<BusinessDataAccessPort>() }
}
