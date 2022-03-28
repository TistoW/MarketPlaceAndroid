package com.inyongtisto.marketplace.core.data.source.remote.response

data class BaseSingelResponse<T>(
        val code: Int? = null,
        val message: String? = null,
        val data: T? = null
)