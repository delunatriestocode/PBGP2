package br.projeto.apanhagastos.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.projeto.apanhagastos.databinding.ActivityLoginBinding
import br.projeto.apanhagastos.main.ui.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    override fun onStart() {
        super.onStart()
            //startMainActivity()
        }

    fun startMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}