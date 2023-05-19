package com.quickstart.business.controller

import com.quickstart.business.dto.BusinessRequestDTO
import com.quickstart.business.dto.toDTO
import com.quickstart.business.ports.primary.CreateBusinessPort
import com.quickstart.business.ports.primary.GetBusinessPort
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import java.util.UUID
import org.koin.ktor.ext.inject

internal fun Routing.businessController() {
    val createBusinessPort by inject<CreateBusinessPort>()
    val getBusinessPort by inject<GetBusinessPort>()

    post("/business") {
        val businessRequestDTO = call.receive<BusinessRequestDTO>()
        val business = createBusinessPort(businessRequestDTO.toModel())
        call.respond(business.toDTO())
    }

    get("/business/{id}") {
        val id = UUID.fromString(call.parameters["id"])
        getBusinessPort.getById(id)?.toDTO()?.let {
            call.respond(it)
        } ?: call.respond(HttpStatusCode.NotFound)
    }
}
