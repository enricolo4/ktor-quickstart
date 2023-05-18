package com.quickstart.individual.shared

import com.quickstart.individual.entity.IndividualsEntity
import org.ufoss.kotysa.R2dbcSqlClient

interface CreateTablesService {
    suspend fun migrations()
}

class CreateTables(
    private val client: R2dbcSqlClient
)  : CreateTablesService{
    override suspend fun migrations() {
        client createTableIfNotExists IndividualsEntity
    }
}
