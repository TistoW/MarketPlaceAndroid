package com.inyongtisto.marketplace.ui.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.inyongtisto.marketplace.R
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.databinding.ActivityNavigationBinding
import com.inyongtisto.marketplace.ui.auth.LoginActivity
import com.inyongtisto.marketplace.ui.toko.TokoSayaActivity
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.intentActivity
import com.inyongtisto.myhelper.extension.logs
import com.inyongtisto.myhelper.extension.toastError
import com.inyongtisto.myhelper.extension.toastSimple
import org.koin.androidx.viewmodel.ext.android.viewModel

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding
    private val viewModel: NavViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNav()
        getUser()
        testingCode()
    }

    private fun testingCode() {
        val x = 1
        val y = 2 // bukan nullable
        val z: Int? = null // nullable

        // z!! // di paksa set value null berpotensi crash/Froce close
        // z ?: 0 // diberi default value

        val result = x + y + (z ?: 5)
        logs("hasil:$result")
    }

    private fun getUser() {
        viewModel.getUser(Prefs.getUser()?.id ?: 0).observe(this) {}
    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)

        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_notifications) {
                if (Prefs.isLogin) { //  true atau false
                    Log.d("TAG", "sudah login")
                    navController.navigate(it.itemId)
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                    Log.d("TAG", "belum login, pindah ke maenu login")
                    return@setOnItemSelectedListener false
                }
            } else {
                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yg lain" + it.itemId)
            }

            return@setOnItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}