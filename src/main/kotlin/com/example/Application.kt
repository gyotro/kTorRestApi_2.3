package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.plugins.callloging.*
import org.koin.core.module.Module
import org.slf4j.event.Level

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module(koinModule: Module) {
    install(CallLogging) {
        level = Level.INFO
    }
    configureDefaultHeaders()
    configureSerialization()
    configureRouting()
}
