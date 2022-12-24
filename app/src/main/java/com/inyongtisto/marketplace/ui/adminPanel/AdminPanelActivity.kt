package com.inyongtisto.marketplace.ui.adminPanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.databinding.ActivityAdminPanelBinding
import com.inyongtisto.marketplace.databinding.ActivityBukaTokoBinding
import com.inyongtisto.marketplace.databinding.ActivityNavigationBinding
import com.inyongtisto.marketplace.databinding.ActivityTokoSayaBinding
import com.inyongtisto.marketplace.ui.alamatToko.ListAlamatTokoActivity
import com.inyongtisto.marketplace.ui.category.ListCategoryAdminActivity
import com.inyongtisto.marketplace.ui.product.CreateProductActivity
import com.inyongtisto.marketplace.ui.product.ListProductTokoActivity
import com.inyongtisto.marketplace.ui.slider.ListSliderAdminActivity
import com.inyongtisto.marketplace.util.Constants
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.getInitial
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.setToolbar
import com.inyongtisto.myhelper.extension.toGone
import com.squareup.picasso.Picasso

class AdminPanelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminPanelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminPanelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.lyToolbar.toolbar, "Admin Panel")
        // get data dari server

        setData()
        setupListener()
    }

    private fun setData() {

    }

    private fun setupListener() {
        binding.apply {
            btnCategory.setOnClickListener {
                intentActivity(ListCategoryAdminActivity::class.java)
            }

            btnSlider.setOnClickListener {
                intentActivity(ListSliderAdminActivity::class.java)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}