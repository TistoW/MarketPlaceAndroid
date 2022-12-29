package com.inyongtisto.marketplace.core.data.source.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlamatToko(
    val label: String? = null,
    val alamat: String? = null,
    val created_at: String? = null,
    val email: String? = null,
    val id: Int? = null,
    val isActive: Boolean? = null,
    val kecamatan: String? = null,
    val kecamatanId: Int? = null,
    val kodepost: String? = null,
    val kota: String? = null,
    val kotaId: Int? = null,
    val phone: String? = null,
    val provinsi: String? = null,
    val provinsiId: Int? = null,
    val tokoId: Int? = null,
    val updated_at: String? = null
):Parcelable