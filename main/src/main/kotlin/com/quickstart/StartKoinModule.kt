package com.quickstart

import com.quickstart.config.persistenceModules
import com.quickstart.modules.domainModules
import com.quickstart.migrations.CreateTablesService
import com.quickstart.config.dataBaseConfig
import io.ktor.server.application.Application
import kotlinx.coroutines.runBlocking
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ktor.ext.inject

fun Application.startKoin() {
    startKoin {
        modules(
            dataBaseConfig,
            domainModules,
            persistenceModules,
        )
    }

    runBlocking {
        val createTablesRepository by inject<CreateTablesService>()
        createTablesRepository.migrations()
    }
}
