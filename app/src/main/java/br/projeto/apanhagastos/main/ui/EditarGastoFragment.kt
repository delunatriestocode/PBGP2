package br.projeto.apanhagastos.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentEditarGastoBinding
import br.projeto.apanhagastos.models.Gasto
import br.projeto.apanhagastos.utils.getAutoCompleteInput
import br.projeto.apanhagastos.utils.getDoubleInput
import br.projeto.apanhagastos.utils.getTextInput
import br.projeto.apanhagastos.utils.navUp

class EditarGastoFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentEditarGastoBinding? = null
    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val categorias = resources.getStringArray(R.array.categorias)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.categoria_list_item, categorias)
        binding.inputCategoria.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarGastoBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupObservers()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnAtualizar.setOnClickListener {
            onAtualizarClick()
        }
    }

    private fun onAtualizarClick() {
        val gasto = getGastoFromInputs()
        viewModel.atualizaGasto(gasto)
        navUp()
    }

    private fun getGastoFromInputs(): Gasto {
        binding.apply {
            return Gasto(
                nomeGasto = getTextInput(inputNomeGasto),
                categoria = getAutoCompleteInput(inputCategoria),
                custo = getDoubleInput(inputValor)
            )
        }
    }

    private fun setupObservers() {
        viewModel.selectedGastoComId.observe(viewLifecycleOwner){
            binding.apply {
                inputNomeGasto.setText(it.nomeGasto)
                inputCategoria.setText(it.categoria)
                inputValor.setText(it.custo.toString())
            }
        }
    }

    private fun setupViews() {
        activity?.setTitle("Editar")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}