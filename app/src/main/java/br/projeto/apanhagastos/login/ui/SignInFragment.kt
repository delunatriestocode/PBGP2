package br.projeto.apanhagastos.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.projeto.apanhagastos.R
import br.projeto.apanhagastos.databinding.FragmentSignInBinding
import br.projeto.apanhagastos.main.ui.MainActivity
import br.projeto.apanhagastos.utils.getTextInput
import br.projeto.apanhagastos.utils.nav
import br.projeto.apanhagastos.utils.toast


class SignInFragment : Fragment() {

    val viewModel by activityViewModels<LoginViewModel>()

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {

            btnEntrar.setOnClickListener {
                onSignInClick()
            }

            tvNovaConta.setOnClickListener {
                onSignOnClick()
            }

        }
    }


    private fun onSignOnClick() {
        nav(R.id.action_signInFragment_to_signOnFragment)
    }

    private fun onSignInClick() {
        val email = getTextInput(binding.inputEmail)
        val password = getTextInput(binding.inputSenha)

        if (email != "" && password != "") {
            signIn(email, password)
        } else {
            toast("Digite um email e uma senha")
        }

    }



    private fun signIn(email: String, password: String){
        viewModel.login(email, password)
            .addOnSuccessListener {
                toast("Logado com Sucesso")
                startMainActivity()
            }
            .addOnFailureListener {
                toast("Falha ao Logar\n${it.message}")
            }
    }

    fun startMainActivity(){
        startActivity(Intent(requireContext(), MainActivity::class.java))
        activity?.finish()
    }


}