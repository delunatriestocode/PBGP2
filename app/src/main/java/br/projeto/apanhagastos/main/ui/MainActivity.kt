package br.projeto.apanhagastos.main.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.ActivityMainBinding
import br.projeto.apanhagastos.login.ui.LoginActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val viewModel by viewModels<MainViewModel>()

    private var anuncioInter: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        bottomNavigationView.setupWithNavController(navController)
    }



        //setupAdMob()
//        setupNavigation()
}

//    private fun setupNavigation() {
//
//    }


    /*private fun setupAdMob() {
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
    */
     







