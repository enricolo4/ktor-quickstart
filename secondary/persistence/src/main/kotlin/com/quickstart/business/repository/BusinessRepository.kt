package com.quickstart.business.repository

import com.quickstart.business.entity.BusinessEntity
import com.quickstart.business.entity.BusinessesEntity
import java.util.UUID
import org.ufoss.kotysa.R2dbcSqlClient

internal class BusinessRepository(
    private val client: R2dbcSqlClient
) {
    suspend fun save(businessEntity: BusinessEntity) = client.transactional {
        client insertAndReturn businessEntity
    }!!

    suspend fun findById(id: UUID) =
        (client selectFrom BusinessesEntity where BusinessesEntity.id eq id).fetchFirstOrNull()
}
