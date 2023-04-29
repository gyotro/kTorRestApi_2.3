package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import kotlinx.html.body
import kotlinx.html.h3
import kotlinx.html.head
import kotlinx.html.title


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
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
