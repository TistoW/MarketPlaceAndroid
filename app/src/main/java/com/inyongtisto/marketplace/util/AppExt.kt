package com.inyongtisto.marketplace.util

fun String?.defaultError(): String {
    return this ?: Constants.DEFALUT_ERROR
}

fun String.toUrlProduct() = Constants.BASE_URL + "storage/product/" + this
fun String?.toUrlCategory() = Constants.BASE_URL + "storage/category/" + this
fun String?.toUrlSlider() = Constants.BASE_URL + "storage/slider/" + this