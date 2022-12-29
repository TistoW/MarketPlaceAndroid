package com.inyongtisto.marketplace.core.data.source.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Toko(
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null,
    val kota: String? = null,
    val updated_at: String? = null,
    val created_at: String? = null,
    val address: AlamatToko? = null,
):Parcelable