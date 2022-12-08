package br.projeto.apanhagastos.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.projeto.apanhagastos.databinding.FragmentCotacaoBinding
import com.google.api.Endpoint
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
        //setup()

        return view
    }

/*
    fun setup() {
        getData()
    }

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://economia.awesomeapi.com.br/json/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getUSDtoBRL()

        callback.enqueue(object : Callback<List<Moeda>> {
            override fun onFailure(call: Call<List<Moeda>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<List<Moeda>>, response: Response<List<Moeda>>){
                response.bid()?.forEach{

                    binding.idTexto.text = binding.idTexto.text.toString().toDouble().plus(it.bid)
                    
                }
            }
        })
    }

*/

}
