package br.projeto.apanhagastos.main.ui

import androidx.lifecycle.ViewModel
import br.projeto.apanhagastos.models.Gasto
import br.projeto.apanhagastos.repositories.CategoriasRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference

class MainViewModel : ViewModel() {

    val TAG = "ViewModel"
    val repository = CategoriasRepository.get()


    fun logout() {
        repository.logout()
    }

    fun cadastrarGasto(gasto: Gasto): Task<DocumentReference> {
        return repository.cadastrarGasto(gasto)
    }



}