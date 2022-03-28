package com.inyongtisto.marketplace.ui.toko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.databinding.ActivityBukaTokoBinding
import com.inyongtisto.marketplace.databinding.ActivityNavigationBinding
import com.inyongtisto.marketplace.databinding.ActivityTokoSayaBinding
import com.inyongtisto.marketplace.ui.alamatToko.ListAlamatTokoActivity
import com.inyongtisto.marketplace.util.Constants
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.setToolbar
import com.inyongtisto.myhelper.extension.toGone
import com.squareup.picasso.Picasso

class TokoSayaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTokoSayaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokoSayaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Toko Saya")
        // get data dari server

        setData()
        setupListener()
    }

    private fun setData() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                if (user.toko != null) {
                    tvName.text = user.toko?.name
                    tvInisial.text = user.toko?.name.getInitial()
                    Picasso.get().load(Constants.USER_URL + user.toko?.name)
                        .into(binding.imageProfile)
                }
            }
        }
    }

    private fun setupListener() {
        binding.apply {
            btnAlamat.setOnClickListener {
                intentActivity(ListAlamatTokoActivity::class.java)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}