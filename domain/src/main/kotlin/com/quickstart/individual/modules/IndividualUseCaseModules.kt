package com.quickstart.individual.modules

import com.quickstart.individual.ports.primary.CreateIndividualPort
import com.quickstart.individual.ports.primary.GetIndividualPort
import com.quickstart.individual.usecase.CreateIndividualUseCase
import com.quickstart.individual.usecase.GetIndividualUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val individualModules = module {
    singleOf(::CreateIndividualUseCase) { bind<CreateIndividualPort>() }
    singleOf(::GetIndividualUseCase) { bind<GetIndividualPort>() }
}
