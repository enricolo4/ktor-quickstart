package com.quickstart

import com.quickstart.individual.modules.individualDataAccessModules
import com.quickstart.individual.modules.individualModules
import com.quickstart.individual.shared.CreateTablesService
import io.ktor.server.application.Application
import kotlinx.coroutines.runBlocking
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ktor.ext.inject

fun Application.startKoin() {
    startKoin {
        modules(
            individualModules,
            individualDataAccessModules
        )
    }

    runBlocking {
        val createTablesRepository by inject<CreateTablesService>()
        createTablesRepository.migrations()
    }
}
