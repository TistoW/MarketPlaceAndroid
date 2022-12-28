package com.inyongtisto.marketplace.ui.navigation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Selamat datang di keranjang"
    }
    val text: LiveData<String> = _text
}