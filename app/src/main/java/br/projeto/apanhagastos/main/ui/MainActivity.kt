package br.projeto.apanhagastos.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.projeto.apanhagastos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setup()
    }

    private fun setup() {
        TODO("Not yet implemented")
    }
}