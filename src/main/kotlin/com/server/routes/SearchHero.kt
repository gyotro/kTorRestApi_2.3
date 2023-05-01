package com.server.routes

import com.server.dao.ApiResponse
import com.server.repository.HeroRepo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeros() {
    val repo: HeroRepo by inject()
    get("/anime/heroes/search") {
        val nameHero = call.request.queryParameters["name"] ?: ""
        if (nameHero.isNotEmpty())
        {
            val response = repo.searchHeroes(name = nameHero)
            call.respond(
                status = HttpStatusCode.OK,
                message = response
            )
        }else {
            call.respond(
                status = HttpStatusCode.NotFound,
                message = ApiResponse (
                    success = false,
                    message = "Hero not found"
                )
            )
        }
    }

}