package br.projeto.apanhagastos.login.ui

import androidx.lifecycle.ViewModel
import br.projeto.apanhagastos.repositories.CategoriasRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class LoginViewModel : ViewModel() {

    val TAG = "ViewModel"
    val repository = CategoriasRepository.get()

    // Auth:

    fun isLoggedIn(): Boolean {
        return repository.isLoggedIn()
    }

    fun login(
        email: String,
        password: String
    ): Task<AuthResult> {
        return CategoriasRepository.auth.signInWithEmailAndPassword(email, password)
    }

    fun signOn(
        email: String,
        password: String
    ): Task<AuthResult> {
        return repository.cadastrarUsuarioComSenha(
            email,
            password
        )
    }

    fun getCurrentUserEmail(): String {
        return repository.getCurrentUser()?.email ?: "Email não encontrado"
    }

}