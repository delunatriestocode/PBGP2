package br.projeto.apanhagastos.utils

import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun Fragment.nav(id: Int){
    findNavController().navigate(id)
}

fun Fragment.navUp(){
    findNavController().navigateUp()
}

fun Fragment.getTextInput(editText: TextInputEditText): String {
    return editText.text.toString()
}


fun Fragment.getIntInput(editText: EditText): Int {
    return editText.text.toString().toInt()
}

fun Fragment.toast(msg: String){
    Toast.makeText(
        requireContext(),
        msg,
        Toast.LENGTH_SHORT
    ).show()
}