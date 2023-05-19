package com.quickstart.config

import com.quickstart.business.entity.BusinessesEntity
import com.quickstart.individual.entity.IndividualsEntity
import com.quickstart.migrations.CreateTables
import com.quickstart.migrations.CreateTablesService
import io.r2dbc.spi.ConnectionFactories
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.ufoss.kotysa.R2dbcSqlClient
import org.ufoss.kotysa.r2dbc.coSqlClient
import org.ufoss.kotysa.tables

val tables = tables().h2(IndividualsEntity, BusinessesEntity)

val connectionFactories = ConnectionFactories.get("r2dbc:h2:mem:///quickstart;DB_CLOSE_DELAY=-1").coSqlClient(tables)

val dataBaseConfig = module {
    singleOf(::connectionFactories) { bind<R2dbcSqlClient>() }
    singleOf(::CreateTables) { bind<CreateTablesService>() }
}
