package com.server.routes

import com.server.dao.ApiResponse
import com.server.repository.HeroRepo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAll() {
    val heroRepo: HeroRepo by inject()
    get("/anime/heroes") {

        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            val apires = heroRepo.getAllHeroes(page = page)
            // adding constraint to page number
            require(page in 1..5)
            call.respond(
                message = apires,
                status = HttpStatusCode.OK
                )
        }catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Only Numbers Allowed!"
                ),
                status = HttpStatusCode.BadRequest
            )
        }catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Only Numbers Allowed!"
                ),
                status = HttpStatusCode.NotFound
            )
        }
    }
}