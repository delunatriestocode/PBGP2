package br.projeto.apanhagastos.login.ui

import androidx.lifecycle.ViewModel
import br.projeto.apanhagastos.repositories.AppRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class LoginViewModel : ViewModel() {

    val TAG = "ViewModel"
    val repository = AppRepository.get()

    // Auth:

    fun isLoggedIn(): Boolean {
        return repository.isLoggedIn()
    }

    fun login(
        email: String,
        password: String
    ): Task<AuthResult> {
        return AppRepository.auth.signInWithEmailAndPassword(email, password)
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