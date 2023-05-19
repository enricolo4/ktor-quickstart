package com.quickstart.business.entity

import com.quickstart.business.model.Business
import java.util.UUID
import org.ufoss.kotysa.h2.H2Table

internal data class BusinessEntity(
    val id: UUID,
    val tradeName: String,
    val nationalRegistration: String
) {
    fun toModel() = Business(
        id = id,
        tradeName = tradeName,
        nationalRegistration = nationalRegistration
    )
}

internal fun Business.toEntity() = BusinessEntity(
    id = id ?: UUID.randomUUID(),
    tradeName = tradeName,
    nationalRegistration = nationalRegistration
)

internal object BusinessesEntity : H2Table<BusinessEntity>("businesses") {
    val id = uuid(BusinessEntity::id).primaryKey()
    val tradeName = varchar(BusinessEntity::tradeName)
    val nationalRegistration = varchar(BusinessEntity::nationalRegistration).unique()
}
