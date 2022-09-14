package com.inyongtisto.marketplace.ui.product

import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.databinding.ActivityAlamatTokoListBinding
import com.inyongtisto.marketplace.databinding.ActivityListDataBinding
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.ui.product.adapter.ProductTokoAdapter
import com.inyongtisto.marketplace.util.defaultError
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListProductTokoActivity : MyActivity() {

    private lateinit var binding: ActivityListDataBinding
    private val viewModel: ProductViewModel by viewModel()
    private var adapter = ProductTokoAdapter { item, pos ->
        confirmDeleteProduct(item, pos)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "List Produk")

        setupUI()
        mainButton()
        getData()
        setupAdapter()
    }

    override fun onResume() {
        getData()
        super.onResume()
    }

    private fun confirmDeleteProduct(item: Product, pos: Int) {
        showConfirmDialog(
            "Delete Produk",
            "Apakah anda yakin ingin menghapus Produk ini?",
            "Delete"
        ) {
            onDelete(item, pos)
        }
    }

    private fun onDelete(item: Product, pos: Int) {
        viewModel.delete(item.id).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    adapter.removeAt(pos)
                    progress.dismiss()
                    toastSuccess("Produk berhasil di hapus")
                }
                State.ERROR -> {
                    showErrorDialog(it.message.defaultError())
                    progress.dismiss()
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        }
    }

    private fun setupUI() {
        binding.apply {
            lyToolbar.btnTambah.toVisible()
            lyToolbar.btnTambah.setOnClickListener {
                intentActivity(CreateProductActivity::class.java)
            }
        }
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