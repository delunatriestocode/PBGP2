package br.projeto.apanhagastos.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.databinding.FragmentCadastrarGastoBinding
import br.projeto.apanhagastos.models.Gasto
import br.projeto.apanhagastos.utils.getTextInput
import br.projeto.apanhagastos.utils.navUp
import br.projeto.apanhagastos.utils.toast

class CadastrarGastoFragment : Fragment() {

    val viewModel by activityViewModels<MainViewModel>()
    private var _binding: FragmentCadastrarGastoBinding? = null
    private val binding get() = _binding!!

    //    override fun onResume() {
    //        super.onResume()
    //        val categorias = resources.getStringArray(R.array.categorias)
    //        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.categoria_list_item, categorias)
    //        binding.inputCategoria.setAdapter(arrayAdapter)
    //    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCadastrarGastoBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnCadastrar.setOnClickListener {
            onCadastrarClick()
        }
    }

    private fun onCadastrarClick() {
        val gasto = getGastoFromInputs()

        viewModel.cadastrarGasto(gasto)
            .addOnSuccessListener { documentReference ->
                toast("Cadastrado com sucesso com id: ${documentReference.id}")
                navUp()
            }
            .addOnFailureListener { e ->
                toast("Falha ao cadastrar")
            }
    }

    private fun onAtualizarClick() {
        val turma = getGastoFromInputs()
        // TODO - Terminar codigo de Cadastro
        // viewModel.atualizaGasto(gasto)
        navUp()
    }

    private fun getGastoFromInputs(): Gasto {
        binding.apply {
            return Gasto(
                nome = getTextInput(inputNomeGasto),
                // TODO - Corrigir tipos dos Inputs
//                categoria = getTextInput(inputCategoria),
//                custo = getTextInput(inputValor)
            )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}