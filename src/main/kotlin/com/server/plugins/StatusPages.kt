package com.server.plugins

import com.server.dao.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.statusPages() {
    install(StatusPages) {
        // in questo modo si gestiscono tutti i casi in cui si invoca una URL mancante
        status(HttpStatusCode.NotFound) { applicationCall, _ ->
            applicationCall.respond(
                status = HttpStatusCode.NotFound,
                message = ApiResponse(
                    success = false,
                    message = "Hero not found"
                )
            )
        }
        exception<Throwable> { call, cause ->
            if(cause is AuthenticationException) {
                call.respond(
                status = HttpStatusCode.Unauthorized,
                message = ApiResponse(
                    success = false,
                    message = cause.message
                )
            )}
            else {
                call.respond(
                    status = HttpStatusCode.InternalServerError,
                    message = ApiResponse(
                        success = false,
                        message = cause.message
                    )
                )
            }
        }
    }
}