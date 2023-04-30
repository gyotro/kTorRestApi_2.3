package com.example.routes

import com.example.dao.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAll() {
    get("/anime/heroes") {

        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            // adding constraint to page number
            require(page in 1..5)
/*            call.respond(
                message = ApiResponse(
                    success = true,

                )
            )*/
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