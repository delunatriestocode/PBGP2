package br.projeto.apanhagastos.application

import android.app.Application
import br.projeto.apanhagastos.repositories.AppRepository

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppRepository.initialize()
    }
}