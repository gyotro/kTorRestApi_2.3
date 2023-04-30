package com.server.di

import com.server.repository.HeroRepo
import com.server.repository.HeroRepoImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepo> {
        HeroRepoImpl()
    }
}