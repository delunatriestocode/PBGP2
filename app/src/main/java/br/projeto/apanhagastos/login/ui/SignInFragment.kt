package br.projeto.apanhagastos.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentSignInBinding
import br.projeto.apanhagastos.main.ui.MainActivity


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root


        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            tvNovaConta.setOnClickListener {
                nav(R.id.action_signInFragment_to_signOnFragment)
            }
            btnEntrar.setOnClickListener{
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    activity?.finish()

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