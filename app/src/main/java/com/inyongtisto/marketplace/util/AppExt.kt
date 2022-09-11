package com.inyongtisto.marketplace.util

fun String?.defaultError(): String {
    return this ?: Constants.DEFALUT_ERROR
}

fun String.toUrlProduct(): String {
    return Constants.BASE_URL + "storage/product/" + this
}