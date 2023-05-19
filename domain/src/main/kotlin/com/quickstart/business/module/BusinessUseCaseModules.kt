package com.quickstart.business.module

import com.quickstart.business.ports.primary.CreateBusinessPort
import com.quickstart.business.ports.primary.GetBusinessPort
import com.quickstart.business.usecase.CreateBusinessUseCase
import com.quickstart.business.usecase.GetBusinessUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val businessModules = module {
    singleOf(::CreateBusinessUseCase) { bind<CreateBusinessPort>() }
    singleOf(::GetBusinessUseCase) { bind<GetBusinessPort>() }
}
