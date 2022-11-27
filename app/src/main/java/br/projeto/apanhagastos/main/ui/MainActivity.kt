package br.projeto.apanhagastos.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.ActivityMainBinding
import br.projeto.apanhagastos.login.ui.LoginActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel by viewModels<MainViewModel>()

    private var anuncioInter: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        setup()
    }



    private fun setup() {
        setupClickListeners()
        setupAdMob()
    }

    private fun setupAdMob() {
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }

    fun adViewClick(view: View) {
        if (anuncioInter != null) {
            anuncioInter?.show(this)
        } else {
            Log.d("INTERSTITIAL", "The interstitial ad wasn't ready yet.")
        }
    }

    private fun setupClickListeners() {
        binding.btnSair.setOnClickListener {
            viewModel.logout()
            startLoginActivity()
        }
        binding.imgHamburgerIcon.setOnClickListener {

        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}