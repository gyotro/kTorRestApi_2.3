package com.server

import io.ktor.server.application.*
import com.server.plugins.*
import io.ktor.server.plugins.callloging.*
import org.koin.core.module.Module
import org.slf4j.event.Level

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(CallLogging) {
        level = Level.INFO
    }
    statusPages()
    configureKoin()
    configureDefaultHeaders()
    configureSerialization()
    configureRouting()
}
