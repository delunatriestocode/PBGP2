package br.projeto.apanhagastos.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentGastosBinding
import br.projeto.apanhagastos.main.ui.adapters.GastoComIdAdapter
import br.projeto.apanhagastos.main.ui.adapters.GastoComIdListener
import br.projeto.apanhagastos.models.GastoComId
import br.projeto.apanhagastos.utils.nav

class GastosFragment : Fragment() {

    val TAG = "GastosFragment"

    val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentGastosBinding? = null
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

    val adapter = GastoComIdAdapter(
        object : GastoComIdListener {
            override fun onEditClick(gasto: GastoComId) {
                viewModel.setSelectedGastoComId(gasto)
                nav(R.id.action_gastosFragment_to_editarGastoFragment)
            }

            override fun onDeleteClick(gasto: GastoComId) {
                viewModel.deleteGasto(gasto)
            }
        }
    )

    fun setup() {
        setupViews()
        setupClickListeners()
        setupRecyclerView()
        setupObservers()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnCadastrar.setOnClickListener {
                nav(R.id.action_gastosFragment_to_cadastrarGastoFragment)
            }
            btnEditar.setOnClickListener {
                nav(R.id.action_gastosFragment_to_editarGastoFragment)
            }
        }
    }

    private fun setupViews() {
        activity?.setTitle("Gastos")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        // adapter precisa ser uma variável global para ser acessada por todos os métodos
        binding.rvGastos.layoutManager = LinearLayoutManager(
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
        binding.rvGastos.adapter = adapter
    }

}

