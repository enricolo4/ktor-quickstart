package com.quickstart.modules

import com.quickstart.business.ports.primary.CreateBusinessPort
import com.quickstart.business.ports.primary.GetBusinessPort
import com.quickstart.individual.ports.primary.CreateIndividualPort
import com.quickstart.individual.ports.primary.GetIndividualPort
import com.quickstart.individual.usecase.CreateIndividualUseCase
import com.quickstart.individual.usecase.GetIndividualUseCase
import com.quickstart.business.usecase.CreateBusinessUseCase
import com.quickstart.business.usecase.GetBusinessUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModules = module {
    singleOf(::CreateIndividualUseCase) { bind<CreateIndividualPort>() }
    singleOf(::GetIndividualUseCase) { bind<GetIndividualPort>() }
    singleOf(::CreateBusinessUseCase) { bind<CreateBusinessPort>() }
    singleOf(::GetBusinessUseCase) { bind<GetBusinessPort>() }
}
