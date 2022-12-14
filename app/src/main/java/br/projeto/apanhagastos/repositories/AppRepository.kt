package br.projeto.apanhagastos.repositories

import br.projeto.apanhagastos.models.Gasto
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class AppRepository private constructor() {


// Inicialização do Firebase Auth:

    companion object {

        lateinit var auth: FirebaseAuth

        lateinit var db: FirebaseFirestore

        lateinit var colecaoGastos : CollectionReference

        private var INSTANCE: AppRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = AppRepository()
            }
            auth = Firebase.auth
            // Banco de dados Firestore
            db = Firebase.firestore

            // Coleção de gastos:
            colecaoGastos = db.collection("gastos")

        }

        fun get(): AppRepository {
            return INSTANCE
                ?: throw IllegalStateException("AppRepository deve ser inicializado.")
        }
    }

    // Autenticação:

    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean {

        if(getCurrentUser() != null) {
            return true
        }
        return false
    }


    fun cadastrarUsuarioComSenha(
        email: String,
        password: String
    ) : Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }

    fun login(
        email: String,
        password: String
    ) : Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun logout(){
        auth.signOut()
    }

    // FireStore - Gastos:

    fun getGastosColecao(): CollectionReference {
        return colecaoGastos
    }

    fun cadastrarGasto(gasto: Gasto): Task<DocumentReference> {
        return colecaoGastos.add(gasto)
    }

    fun deleteGasto(id: String): Task<Void> {
        return colecaoGastos.document(id).delete()
    }

    fun atualizaGasto(id: String?, gasto: Gasto) {
        if (id != null) {
            colecaoGastos.document(id).set(gasto)
        }
    }

}