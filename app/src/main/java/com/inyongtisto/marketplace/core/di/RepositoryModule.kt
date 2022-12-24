package com.inyongtisto.marketplace.core.di

import com.inyongtisto.marketplace.core.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
    single { AlamatRepository(get(), get()) }
    single { ProductRepository(get(), get()) }
    single { CategoryRepository(get(), get()) }
    single { SliderRepository(get(), get()) }
}