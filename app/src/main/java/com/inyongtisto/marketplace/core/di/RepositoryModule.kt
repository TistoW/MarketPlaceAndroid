package com.inyongtisto.marketplace.core.di

import com.inyongtisto.marketplace.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}