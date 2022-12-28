package com.inyongtisto.marketplace.ui.navigation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.inyongtisto.marketplace.ui.navigation.NavigationActivity
import com.inyongtisto.marketplace.databinding.FragmentAkunBinding
import com.inyongtisto.marketplace.ui.adminPanel.AdminPanelActivity
import com.inyongtisto.marketplace.ui.toko.BukaTokoActivity
import com.inyongtisto.marketplace.ui.toko.TokoSayaActivity
import com.inyongtisto.marketplace.ui.updateProfile.UpdateProfileActivity
import com.inyongtisto.marketplace.util.Constants.USER_URL
import com.inyongtisto.marketplace.util.Prefs
import com.inyongtisto.myhelper.extension.*
import com.squareup.picasso.Picasso

class AccountFragment : Fragment() {

    private lateinit var notificationsViewModel: AccountViewModel
    private var _binding: FragmentAkunBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)

        _binding = FragmentAkunBinding.inflate(inflater, container, false)
        val root: View = binding.root


        mainButton()
        return root
    }

    override fun onResume() {
        setUser()
        super.onResume()
    }

    private fun mainButton() {
        binding.btnLogout.setOnClickListener {
            Prefs.isLogin = false
            pushActivity(NavigationActivity::class.java)
        }

        binding.btnUpdate.setOnClickListener {
            intentActivity(UpdateProfileActivity::class.java)
        }

        binding.btnAdmin.setOnClickListener {
            intentActivity(AdminPanelActivity::class.java)
        }
    }

    private fun setUser() {
        val user = Prefs.getUser()
        if (user != null) {
            binding.apply {
                tvName.text = user.name
                tvEmail.text = user.email
                tvPhone.text = user.phone
                tvInisial.text = user.name.getInitial()

                Picasso.get().load(USER_URL + user.image).into(binding.imageProfile)

                if (user.toko != null) {
                    tvStatusToko.toGone()
                    tvNameToko.text = user.toko?.name
                    binding.btnToko.setOnClickListener {
                        intentActivity(TokoSayaActivity::class.java)
                    }
                } else {
                    binding.btnToko.setOnClickListener {
                        intentActivity(BukaTokoActivity::class.java)
                    }
                }
                logs("user:" + Prefs.getUser())
                btnAdmin.visible(Prefs.getUser()?.isAdmin() ?: false)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}