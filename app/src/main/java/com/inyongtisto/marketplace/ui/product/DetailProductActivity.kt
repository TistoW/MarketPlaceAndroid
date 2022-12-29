package com.inyongtisto.marketplace.ui.product

import android.annotation.SuppressLint
import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.databinding.ActivityDetailProductBinding
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.ui.product.adapter.ImageProductSliderAdapter
import com.inyongtisto.marketplace.ui.toko.TokoViewModel
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailProductActivity : MyActivity() {

    private lateinit var binding: ActivityDetailProductBinding
    private val viewModel: TokoViewModel by viewModel()
    private val product by extra<Product>()
    private val adapter = ImageProductSliderAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        product?.let {
            logs("product:" + it.toJson())
            binding.tvNameProduct.text = it.name
        }

        mainButton()
        setAdapter()
        setupData()
    }

    @SuppressLint("SetTextI18n")
    private fun setupData() {
        binding.apply {
            product?.let {
                val harga = it.price ?: 0
                tvPrice.text = harga.toRupiah()
                tvStok.text = it.stock.formatCurrency()
                tvSold.text = it.sold.formatCurrency()
                tvCity.text = it.store?.address?.kota
                tvNameStore.text = it.store?.name
                tvDescription.text = it.description
                if (it.discount != 0) {
                    val discount = it.discount.toDouble()
                    lyDiskon.visible(discount > 0)
                    tvDiscount.text = "${it.discount}%"
                    tvPrice.text = (harga - ((discount / 100) * harga)).toRupiah()
                    tvHargaAsli.text = it.price.toRupiah()
                    tvHargaAsli.coret()
                }
            }
        }
    }

    private fun setAdapter() {
        binding.apply {
            val image = product?.images ?: ""
            val splitImages = image.split("|")
            adapter.addItems(splitImages)
            sliderImage.adapter = adapter
        }
    }

    private fun mainButton() {
        binding.apply {
            btnBack.setOnClickListener {
                onBack()
            }
        }
    }
}