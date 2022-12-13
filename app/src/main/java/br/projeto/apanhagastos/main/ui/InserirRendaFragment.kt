package br.projeto.apanhagastos.main.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.databinding.FragmentInserirRendaBinding
import br.projeto.apanhagastos.utils.getDoubleInput
import br.projeto.apanhagastos.utils.getIntInput
import br.projeto.apanhagastos.utils.getTextInput
import br.projeto.apanhagastos.utils.toast

class InserirRendaFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentInserirRendaBinding? = null
    private val binding get() = _binding!!

    private lateinit var renda: RendaMensalComunicador

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInserirRendaBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }
/*

    // Verifica se o arquivo pai contem a interface
    private lateinit var listener: RendaMensalComunicador
    override fun onAttach(context: Context) {
        if (context is RendaMensalComunicador){
            listener = context
        }
        super.onAttach(context)
    }
*/

    private fun setup() {
        setupClickListeners()
    }

    // Envia a renda mensal para a Activity
    private fun setupClickListeners() {


        binding.btnAtualizarRenda.setOnClickListener {
            /*val renda = getDoubleInput(binding.inputRendaMensal)
            if (renda > 0) {
                listener.pegarRenda(renda)
            } else {
                toast("Por favor, insira sua renda mensal")
            }*/
        }


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
