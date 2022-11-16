package br.projeto.apanhagastos.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentSignOnBinding


class SignOnFragment : Fragment() {
    private var _binding: FragmentSignOnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignOnBinding.inflate(inflater, container, false)
        val view = binding.root


        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            tvTemConta.setOnClickListener {
                nav(R.id.action_signOnFragment_to_signInFragment)
            }
        }
    }

    fun nav(id: Int) {
        findNavController().navigate(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}