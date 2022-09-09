package com.inyongtisto.marketplace.ui.product

import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.model.Product
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.databinding.ActivityCreateProductBinding
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.util.defaultError
import com.inyongtisto.marketplace.util.getTokoId
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class CreateProductActivity : MyActivity() {

    private lateinit var binding: ActivityCreateProductBinding
    private val viewModel: ProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Tambah Alamat")

        setupUI()
        mainButton()
    }

    private fun setupUI() {

    }

    private fun mainButton() {
        binding.apply {
            lyToolbar.btnSimpan.toVisible()
            lyToolbar.btnSimpan.setOnClickListener {
                if (validate()) create()
            }

            edtHarga.addRupiahListener()

            lyToolbar.btnSimpan.setOnLongClickListener {
                edtName.setText("Mukena Cantik")
                edtHarga.setText(Random.nextInt(10000, 90000).toString())
                edtBerat.setText("1000")
                edtStok.setText("10")
                edtDeskripsi.setText("Deskripsi " + edtName.getString())
                return@setOnLongClickListener true
            }
        }
    }

    private fun validate(): Boolean {
        binding.apply {
            if (edtName.isEmpty()) return false
            if (edtHarga.isEmpty()) return false
            if (edtBerat.isEmpty()) return false
            if (edtStok.isEmpty()) return false
            if (edtDeskripsi.isEmpty()) return false
        }
        return true
    }

    private fun create() {
        val reqData = Product(
            tokoId = getTokoId(),
            name = binding.edtName.getString(),
            price = binding.edtHarga.getString().remove(",").toInt(),
            description = binding.edtDeskripsi.getString(),
            wight = binding.edtBerat.getString().toInt(),
            stock = binding.edtStok.getString().toInt(),
            images = "1320105_gamis3.jpg"

        )
        viewModel.create(reqData).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    toastSuccess("Berhasil menambah alamat")
                    onBackPressed()
                }
                State.ERROR -> {
                    progress.dismiss()
                    showErrorDialog(it.message.defaultError())
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}