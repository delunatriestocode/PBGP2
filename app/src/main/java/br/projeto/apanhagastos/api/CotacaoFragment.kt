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

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CotacaoFragment : Fragment() {

    private var _binding: FragmentCotacaoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View/*?*/ {
        _binding = FragmentCotacaoBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()

        return view
    }

    fun setup() {
        getData()
        setupAdMob()
    }

    private fun setupAdMob() {
        MobileAds.initialize(requireContext()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }

    private fun getData() {
        getUSDtoBRL()
        getEURtoBRL()
        getGBPtoBRL()
        getJPYtoBRL()
        getAUDtoBRL()
        getCHFtoBRL()
        getCADtoBRL()
        getCNYtoBRL()
        getARStoBRL()
    }


    private fun getUSDtoBRL() {
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
                    binding.cotDolarUsa.text = binding.cotDolarUsa.text.toString().plus(it.bid)
                }
            }
        })
    }
    private fun getEURtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getEURtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotEuro.text = binding.cotEuro.text.toString().plus(it.bid)                }
            }
        })
    }
    private fun getGBPtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getGBPtoBRL()


        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotLibra.text = binding.cotLibra.text.toString().plus(it.bid)                }
            }
        })
    }
    private fun getJPYtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getJPYtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotIene.text = binding.cotIene.text.toString().plus(it.bid)
                }
            }
        })
    }
    private fun getAUDtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getAUDtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotDolarAus.text = binding.cotDolarAus.text.toString().plus(it.bid)
                }
            }
        })
    }
    private fun getCHFtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getCHFtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotFranSui.text = binding.cotFranSui.text.toString().plus(it.bid)
                }
            }
        })
    }
    private fun getCADtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getCADtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotDolarCan.text = binding.cotDolarCan.text.toString().plus(it.bid)
                }
            }
        })
    }
    private fun getCNYtoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getCNYtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotYuan.text = binding.cotYuan.text.toString().plus(it.bid)
                }
            }
        })
    }
    private fun getARStoBRL() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getARStoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.body()?.forEach{
                    binding.cotPesoArg.text = binding.cotPesoArg.text.toString().plus(it.bid)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
