package com.inyongtisto.marketplace.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hi, Im Developer"
    }
    val text: LiveData<String> = _text

    fun ubahData(){
        _text.postValue("Ini aku jadi koki")
    }
}