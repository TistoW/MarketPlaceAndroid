package com.inyongtisto.marketplace.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inyongtisto.marketplace.core.data.repository.AppRepository

class LoginViewModel(val repo: AppRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hi, Im Developer"
    }
    val text: LiveData<String> = _text

    fun ubahData(){
        _text.postValue("Ini aku jadi koki")
    }

}