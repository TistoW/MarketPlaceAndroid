package com.inyongtisto.marketplace.util

fun String?.defaultError(): String {
    return this ?: Constants.DEFALUT_ERROR
}