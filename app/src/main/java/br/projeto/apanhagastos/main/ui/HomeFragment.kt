package br.projeto.apanhagastos.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentHomeBinding
import br.projeto.apanhagastos.login.ui.LoginActivity



class HomeFragment : Fragment() {

    val viewModel by viewModels<MainViewModel>()
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()}
    
    private fun setupClickListeners() {
        binding.btnSair.setOnClickListener {
            viewModel.logout()
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}