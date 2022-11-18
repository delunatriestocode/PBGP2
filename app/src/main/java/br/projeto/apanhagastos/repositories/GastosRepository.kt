package br.projeto.apanhagastos.repositories

import br.projeto.apanhagastos.models.Gastos
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



const val TAG = "GastosFirebase"

class GastosRepository private constructor() {


// Inicialização do Firebase Auth

    companion object {

        lateinit var auth: FirebaseAuth

        lateinit var db: FirebaseFirestore

        lateinit var colecaoGastos : CollectionReference

        private var INSTANCE: GastosRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = GastosRepository()
            }
            auth = Firebase.auth
            // Banco de dados Firestore
            db = Firebase.firestore

            // Coleção de gastos:
            colecaoGastos = db.collection("gastos")


        }

        fun get(): GastosRepository {
            return INSTANCE
                ?: throw IllegalStateException("GastosRepository deve ser inicializado.")
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

    // FireStore:

    fun cadastrarGasto(gasto: Gastos): Task<DocumentReference> {
        return  colecaoGastos.add(gasto)
    }

    fun getGastos() : Task<QuerySnapshot> {
        return colecaoGastos.get()
    }

    fun getGastosColecao(): CollectionReference {
        return colecaoGastos
    }

    fun deleteGastos(id: String) {

    }

}