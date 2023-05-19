package com.quickstart.migrations

import com.quickstart.business.entity.BusinessesEntity
import com.quickstart.individual.entity.IndividualsEntity
import org.ufoss.kotysa.R2dbcSqlClient

interface CreateTablesService {
    suspend fun migrations()
}

internal class CreateTables(
    private val client: R2dbcSqlClient
)  : CreateTablesService {
    override suspend fun migrations() {
        client createTableIfNotExists IndividualsEntity
        client createTableIfNotExists BusinessesEntity
    }
}
