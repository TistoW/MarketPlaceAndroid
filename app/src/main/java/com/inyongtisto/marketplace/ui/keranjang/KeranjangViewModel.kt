package com.inyongtisto.marketplace.ui.keranjang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KeranjangViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Selamat datang di keranjang"
    }
    val text: LiveData<String> = _text
}