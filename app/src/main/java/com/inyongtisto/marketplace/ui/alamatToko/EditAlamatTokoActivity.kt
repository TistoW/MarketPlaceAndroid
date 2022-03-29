package com.inyongtisto.marketplace.ui.alamatToko

import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.model.AlamatToko
import com.inyongtisto.marketplace.core.data.source.model.Toko
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.core.data.source.remote.request.CreateTokoRequest
import com.inyongtisto.marketplace.databinding.ActivityBukaTokoBinding
import com.inyongtisto.marketplace.databinding.ActivityTambahAlamatTokoBinding
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.ui.toko.TokoViewModel
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.marketplace.util.defaultError
import com.inyongtisto.marketplace.util.getTokoId
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditAlamatTokoActivity : MyActivity() {

    private lateinit var binding: ActivityTambahAlamatTokoBinding
    private val viewModel: AlamatTokoViewModel by viewModel()
    private var provinsiId: Int? = null
    private var kotaId: Int? = null
    private var kecamatanId: Int? = null
    private var provinsi: String? = null
    private var kota: String? = null
    private var kecamatan: String? = null

    private var alamat = AlamatToko()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahAlamatTokoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Ubah Alamat")

        getExtra()
        setupUI()
        mainButton()
    }

    private fun getExtra() {
        val extra: String? = getStringExtra()
        alamat = extra.toModel(AlamatToko::class.java) ?: AlamatToko()

        binding.apply {
            edtLabel.setText(alamat.label ?: "Rumah")
            edtAlamat.setText(alamat.alamat)
            edtKodePos.setText(alamat.kodepost)
            edtEmail.setText(alamat.email)
            edtPhone.setText(alamat.phone)
        }
    }

    private fun setupUI() {
        //                          0,                 1,              2,             3
        val listProvinsi = listOf("Pilih Provinsi", "Jawa Timur", "Jawa Tengah", "Jawa Barat")
        val listKota = listOf("Pilih Kota", "Lamongan", "Semarang", "Bogor")
        val listKecamatan = listOf("Pilih Kecamatan", "Solokuro", "Ngalian", "Ngaglik")

        binding.spnProvinsi.setOnPositionSelectedListener(this, listProvinsi) {
            if (it == 0) {
                provinsiId = null
            } else {
                // it == 1
                provinsiId = 10
                provinsi = listProvinsi[it]
            }
        }

        binding.spnKota.setOnPositionSelectedListener(this, listKota) {
            if (it == 0) {
                kotaId = null
            } else {
                // it == 1
                kotaId = 399
                kota = listKota[it]
            }
        }

        binding.spnKecamatan.setOnPositionSelectedListener(this, listKecamatan) {
            if (it == 0) {
                kecamatanId = null
            } else {
                // it == 1
                kecamatanId = 5505
                kecamatan = listKecamatan[it]
            }
        }

        binding.apply {
            val indexProv = listProvinsi.indexOfFirst { it == alamat.provinsi }
            spnProvinsi.setSelection(indexProv)

            val indexKota = listKota.indexOfFirst { it == alamat.kota }
            spnKota.setSelection(indexKota)

            val indexKec = listKecamatan.indexOfFirst { it == alamat.kecamatan }
            spnKecamatan.setSelection(indexKec)
        }

    }

    private fun mainButton() {
        binding.apply {
            lyToolbar.btnSimpan.toVisible()
            lyToolbar.btnSimpan.setOnClickListener {
                if (validate()) simpan()
            }
            lyToolbar.btnSimpan.setOnLongClickListener {
                edtLabel.setText("Rumah")
                edtAlamat.setText("Jl. Kenangan bersama mantan")
                edtKodePos.setText("98347")
                edtEmail.setText("email@gmail.com")
                edtPhone.setText("0812345678")
                return@setOnLongClickListener true
            }
        }
    }

    private fun validate(): Boolean {
        binding.apply {
            if (edtLabel.isEmpty()) return false
            if (edtAlamat.isEmpty()) return false
            if (edtKodePos.isEmpty()) return false
            if (edtEmail.isEmpty()) return false
            if (edtPhone.isEmpty()) return false
            if (provinsiId == null) {
                toastSimple("Harap pilih Provinsi")
                return false
            }
            if (kotaId == null) {
                toastSimple("Harap pilih Kota")
                return false
            }
            if (kecamatanId == null) {
                toastSimple("Harap pilih Kecamatan")
                return false
            }
        }
        return true
    }

    private fun simpan() {
        val reqData = AlamatToko(
            id = alamat.id,
            tokoId = getTokoId(),
            label = binding.edtLabel.getString(),
            alamat = binding.edtAlamat.getString(),
            provinsi = provinsi,
            kota = kota,
            kecamatan = kecamatan,
            provinsiId = provinsiId,
            kotaId = kotaId,
            kecamatanId = kotaId,
            kodepost = binding.edtKodePos.getString(),
            email = binding.edtEmail.getString(),
            phone = binding.edtPhone.getString(),
        )
        viewModel.update(reqData).observe(this) {
            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    toastSuccess("Berhasil merubah data alamat")
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