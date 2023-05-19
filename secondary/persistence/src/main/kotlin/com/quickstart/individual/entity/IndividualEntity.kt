package com.quickstart.individual.entity

import com.quickstart.individual.model.Individual
import java.util.UUID
import org.ufoss.kotysa.h2.H2Table

internal data class IndividualEntity(
    val id: UUID,
    val name: String,
    val nationalRegistration: String
) {
    fun toModel() = Individual(id, name, nationalRegistration)
}

internal fun Individual.toEntity() = IndividualEntity(id ?: UUID.randomUUID(), name, nationalRegistration)

internal object IndividualsEntity : H2Table<IndividualEntity>("individuals") {
    val id = uuid(IndividualEntity::id).primaryKey()
    val name = varchar(IndividualEntity::name)
    val nationalRegistration = varchar(IndividualEntity::nationalRegistration).unique()
}
