package com.quickstart.individual.modules

import com.quickstart.individual.adapter.IndividualDataAccessAdapter
import com.quickstart.individual.entity.IndividualsEntity
import com.quickstart.individual.ports.secondary.IndividualDataAccessPort
import com.quickstart.individual.repository.IndividualRepository
import com.quickstart.individual.shared.CreateTables
import com.quickstart.individual.shared.CreateTablesService
import io.r2dbc.spi.ConnectionFactories
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ufoss.kotysa.R2dbcSqlClient
import org.ufoss.kotysa.r2dbc.coSqlClient
import org.ufoss.kotysa.tables


val tables = tables().h2(IndividualsEntity)

val connectionFactories = ConnectionFactories.get("r2dbc:h2:mem:///quickstart;DB_CLOSE_DELAY=-1").coSqlClient(tables)

val individualDataAccessModules = module {
    singleOf(::connectionFactories) { bind<R2dbcSqlClient>() }
    singleOf(::IndividualRepository)
    singleOf(::IndividualDataAccessAdapter) { bind<IndividualDataAccessPort>() }
    singleOf(::CreateTables) { bind<CreateTablesService>() }
}
