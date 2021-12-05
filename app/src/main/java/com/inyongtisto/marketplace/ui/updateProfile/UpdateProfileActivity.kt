package com.inyongtisto.marketplace.ui.updateProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.marketplace.core.data.source.remote.network.State
import com.inyongtisto.marketplace.core.data.source.remote.request.UpdateProfileRequest
import com.inyongtisto.marketplace.databinding.ActivityUpdateProfileBinding
import com.inyongtisto.marketplace.ui.auth.AuthViewModel
import com.inyongtisto.marketplace.ui.base.MyActivity
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UpdateProfileActivity : MyActivity() {

    private val viewModel: AuthViewModel by viewModel()

    private var _binding: ActivityUpdateProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar(binding.toolbar, "Update Profile")

        mainButton()
        setData()
    }

    private fun setData() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                edtName.setText(user.name)
                edtEmail.setText(user.email)
                edtPhone.setText(user.phone)
            }
        }
    }

    private fun mainButton() {
        binding.btnSimpan.setOnClickListener {
            register()
        }
    }

    private fun register() {

        if (binding.edtName.isEmpty()) return
        if (binding.edtPhone.isEmpty()) return
        if (binding.edtEmail.isEmpty()) return

        val idUser = Prefs.getUser()?.id
        val body = UpdateProfileRequest(
            idUser.int(),
            phone = binding.edtPhone.text.toString(),
            email = binding.edtEmail.text.toString(),
            name = binding.edtName.text.toString()
        )

        viewModel.updateUser(body).observe(this, {

            when (it.state) {
                State.SUCCESS -> {
                    progress.dismiss()
                    showToast("Selamat datang " + it.data?.name)
                    onBackPressed()
                }
                State.ERROR -> {
                    progress.dismiss()
                    toastError(it.message ?: "Error")
                }
                State.LOADING -> {
                    progress.show()
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}