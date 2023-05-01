package com.server.plugins

import com.server.routes.getAll
import com.server.routes.root
import com.server.routes.searchHeros
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import kotlinx.html.body
import kotlinx.html.h3
import kotlinx.html.head
import kotlinx.html.title


fun Application.configureRouting() {
    routing {
        // Real API routes for the application
        root()
        getAll()
        searchHeros()
        // Example routes
        get("/welcome") {
            val name = call.request.queryParameters["name"] ?: ""
            call.respondHtml{
                this.head {
                    title { +"Custom Title" }
                }
                this.body {
                    if(name.isBlank()) {
                        h3{ +"Welcome!!" }
                    }
                    else {
                        h3{ +"Welcome $name!!" }
                    }
                }
            }
        }
    }
}
