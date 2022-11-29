package br.projeto.apanhagastos.main.ui

import androidx.lifecycle.ViewModel
import br.projeto.apanhagastos.models.Gasto
import br.projeto.apanhagastos.repositories.CategoriasRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference

class MainViewModel : ViewModel() {

    val TAG = "ViewModel"
    val repository = CategoriasRepository.get()

    fun getCurrentUserEmail(): String {
        return repository.getCurrentUser()?.email ?: "Email não encontrado"
    }

    fun logout() {
        repository.logout()
    }

    fun cadastrarGasto(gasto: Gasto): Task<DocumentReference> {
        return repository.cadastrarGasto(gasto)
    }



    fun atualizaTurma(gasto: Gasto) {
        // TODO - Trocar Id por Categoria
        // repository.atualizaGasto(selectedGastoComCategoria.value?.id, gasto)
    }




}