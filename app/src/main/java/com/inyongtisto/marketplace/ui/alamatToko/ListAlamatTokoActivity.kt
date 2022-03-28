package com.inyongtisto.marketplace.ui.alamatToko

import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.databinding.ActivityAlamatTokoListBinding
import com.inyongtisto.marketplace.ui.alamatToko.adapter.AlamatTokoAdapter
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.ui.toko.TokoViewModel
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListAlamatTokoActivity : MyActivity() {

    private lateinit var binding: ActivityAlamatTokoListBinding
    private val viewModel: AlamatTokoViewModel by viewModel()
    private var adapter = AlamatTokoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlamatTokoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "List Alamat")

        mainButton()
        getData()
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.rvData.adapter = adapter
    }

    private fun getData() {
        viewModel.get().observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    binding.tvError.toGone()
                    val data = it.data ?: emptyList()
                    adapter.addItems(data)

                    if (data.isEmpty()) {
                        binding.tvError.toVisible()
                    }
                }
                State.ERROR -> {
                    binding.tvError.toVisible()
                }
                State.LOADING -> {

                }
            }
        }
    }

    private fun mainButton() {

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}