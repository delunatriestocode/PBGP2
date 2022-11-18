package br.projeto.apanhagastos.application

import android.app.Application
import br.projeto.apanhagastos.repositories.CategoriasRepository

class CategoriasApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        CategoriasRepository.initialize()
    }
}