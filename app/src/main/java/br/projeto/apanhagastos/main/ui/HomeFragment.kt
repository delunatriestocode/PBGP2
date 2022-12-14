package br.projeto.apanhagastos.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentHomeBinding
import br.projeto.apanhagastos.login.ui.LoginActivity
import br.projeto.apanhagastos.main.ui.adapters.GastoComIdAdapter
import br.projeto.apanhagastos.main.ui.adapters.GastoComIdListener
import br.projeto.apanhagastos.main.ui.adapters.GastoHomeAdapter
import br.projeto.apanhagastos.models.GastoComId
import br.projeto.apanhagastos.utils.nav


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

    val adapter = GastoHomeAdapter()


    private fun setup() {
        setupClickListeners()
        setupObservers()
        setupRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        binding.rvGastosHome.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setupObservers() {
        viewModel.gastosComId.observe(viewLifecycleOwner) {
            atualizaRecyclerView(it)
        }
    }

    fun atualizaRecyclerView(lista: List<GastoComId>) {
        adapter.submitList(lista)
        binding.rvGastosHome.adapter = adapter
    }


    // Sair da conta
    private fun setupClickListeners() {
        binding.btnSair.setOnClickListener {
            viewModel.logout()
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(requireContext(), LoginActivity::class.java))
        activity?.finish()
    }


}