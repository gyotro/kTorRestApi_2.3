package com.example.di

import com.example.repository.HeroRepo
import com.example.repository.HeroRepoImpl
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepo> {
        HeroRepoImpl()
    }
}