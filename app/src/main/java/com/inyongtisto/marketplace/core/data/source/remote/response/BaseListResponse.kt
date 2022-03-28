package com.inyongtisto.marketplace.core.data.source.remote.response

data class BaseListResponse<T>(
    val code: Int? = null,
    val message: String? = null,
    val data: List<T> = emptyList()
)