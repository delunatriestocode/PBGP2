package br.projeto.apanhagastos.main.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.ActivityMainBinding
import br.projeto.apanhagastos.login.ui.LoginActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {


    val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // AdMob Test:
//        MobileAds.initialize(this) {}
//        val adRequest = AdRequest.Builder().build()
//        binding.adView.loadAd(adRequest)
        ////////////////

        setup()
    }



    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSair.setOnClickListener {
            viewModel.logout()
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }







}