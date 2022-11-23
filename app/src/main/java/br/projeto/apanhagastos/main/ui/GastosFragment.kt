package br.projeto.apanhagastos.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.databinding.FragmentGastosBinding

class GastosFragment : Fragment() {

    val TAG = "GastosFragment"

    val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentGastosBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGastosBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    fun setup() {
        TODO("Not yet implemented")
    }
}

