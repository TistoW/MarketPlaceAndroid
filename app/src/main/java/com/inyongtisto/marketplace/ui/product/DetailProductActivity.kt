package com.inyongtisto.marketplace.ui.product

import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.model.Toko
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.databinding.ActivityBukaTokoBinding
import com.inyongtisto.marketplace.databinding.ActivityDetailProductBinding
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.ui.toko.TokoViewModel
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailProductActivity : MyActivity() {

    private lateinit var binding: ActivityDetailProductBinding
    private val viewModel: TokoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainButton()
    }

    private fun mainButton() {
        binding.apply {
            btnBack.setOnClickListener {
                onBack()
            }
        }
    }
}