package br.projeto.apanhagastos.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.databinding.FragmentInserirRendaBinding

class InserirRendaFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentInserirRendaBinding? = null
    private val binding get() = _binding!!

    // private lateinit var renda: RendaMensalComunicador

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInserirRendaBinding.inflate(inflater, container, false)
        val view = binding.root
        // setup()
        return view
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
