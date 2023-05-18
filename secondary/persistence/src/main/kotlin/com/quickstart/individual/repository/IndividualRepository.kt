package com.quickstart.individual.repository

import com.quickstart.individual.entity.IndividualEntity
import com.quickstart.individual.entity.IndividualsEntity
import java.util.UUID
import org.ufoss.kotysa.R2dbcSqlClient

internal class IndividualRepository(
    private val client: R2dbcSqlClient
) {
    suspend fun save(individual: IndividualEntity) = client.transactional {
        client insertAndReturn individual
    }!!

    suspend fun findById(id: UUID) = (client selectFrom IndividualsEntity where IndividualsEntity.id eq id).fetchFirstOrNull()
}
