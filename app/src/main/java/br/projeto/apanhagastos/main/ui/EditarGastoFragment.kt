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

class EditarGastoFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentEditarGastoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarGastoBinding.inflate(inflater, container, false)
        val view = binding.root

        val categorias = resources.getStringArray(R.array.categorias)

//        val autoCompleteTxt = binding.inputCategoria
//
//        val adapterItems = ArrayAdapter<String>(this, R.layout.categoria_list_item, items)
//        autoCompleteTxt.setAdapter<ArrayAdapter<String>>(adapterItems)
//
//        autoCompleteTxt.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
//            val item = parent.getItemAtPosition(position).toString()
//            Toast.makeText(context, "Item: $item", Toast.LENGTH_SHORT).show()
//        })



        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupObservers()
        setupClickListeners()
        setupSelectCategoria()
    }

    private fun setupSelectCategoria() {



    }

    private fun setupClickListeners() {
        TODO("Not yet implemented")
    }

    private fun setupObservers() {
        TODO("Not yet implemented")
    }

    private fun setupViews() {
        TODO("Not yet implemented")
    }
}