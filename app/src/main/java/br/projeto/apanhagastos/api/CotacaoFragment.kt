package br.projeto.apanhagastos.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.projeto.apanhagastos.databinding.FragmentCotacaoBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CotacaoFragment : Fragment() {

    private var _binding: FragmentCotacaoBinding? = null
    private val binding get() = _binding!!
    private var anuncioInter: InterstitialAd? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCotacaoBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()

        return view
    }

    fun setup() {
        getData()
        setupAdMob()
    }

    //  - Descobrir Error de config de API + terminar de aplicar a outras moedas
    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getUSDtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{

                    binding.idTexto.text = binding.idTexto.text.toString().plus(it.bid)

                }
            }
        })
    }


    private fun setupAdMob() {
        MobileAds.initialize(requireContext()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
