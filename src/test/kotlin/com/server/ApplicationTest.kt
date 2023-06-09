//package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
//import kotlin.test.*
import io.ktor.http.*
import com.server.plugins.configureRouting
import junit.framework.TestCase.assertEquals

import org.junit.Test

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Welcome To Hero Api", bodyAsText())
        }
    }
}
