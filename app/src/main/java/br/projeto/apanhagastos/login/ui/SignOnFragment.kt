package br.projeto.apanhagastos.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentSignOnBinding
import br.projeto.apanhagastos.main.ui.MainActivity
import br.projeto.apanhagastos.utils.getTextInput
import br.projeto.apanhagastos.utils.nav
import br.projeto.apanhagastos.utils.toast


class SignOnFragment : Fragment() {

    val viewModel by activityViewModels<LoginViewModel> ()

    private var _binding: FragmentSignOnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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
            btnCadastrar.setOnClickListener {
                onSignOnClick()
            }
            tvTemConta.setOnClickListener {
                nav(R.id.action_signOnFragment_to_signInFragment)
            }
        }
    }

    private fun onSignOnClick() {
        binding.apply {
            val email = getTextInput(inputEmail)
            val password = getTextInput(inputPassword)
            val confirmPassword = getTextInput(inputConfirmPassword)

            if ( (password == confirmPassword) && password.length > 5){
                signOn(email, password)
            }
        }
    }

    fun signOn(email: String, password: String){
        viewModel.signOn(email, password)
            .addOnSuccessListener {
                toast("Cadastrado com Sucesso")
                startMainActivity()
            }
            .addOnFailureListener {
                toast("Falha ao cadastrar\n${it.message}")
            }
    }

    fun startMainActivity(){
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}