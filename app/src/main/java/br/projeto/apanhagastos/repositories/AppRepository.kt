package br.projeto.apanhagastos.repositories

import br.projeto.apanhagastos.models.Usuario
import br.projeto.apanhagastos.models.Gasto
import br.projeto.apanhagastos.models.GastoComId
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



const val TAG = "UsuariosFirebase"

class UsuariosRepository private constructor() {


// Inicialização do Firebase Auth:

    companion object {

        lateinit var auth: FirebaseAuth

        lateinit var db: FirebaseFirestore

        lateinit var colecaoUsuarios : CollectionReference

        lateinit var colecaoGastos : CollectionReference

        private var INSTANCE: UsuariosRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = UsuariosRepository()
            }
            auth = Firebase.auth
            // Banco de dados Firestore
            db = Firebase.firestore

            // Coleção de usuarios:
            colecaoUsuarios = db.collection("usuarios")

            // Coleção de gastos:
            colecaoGastos = db.collection("gastos")

        }

        fun get(): UsuariosRepository {
            return INSTANCE
                ?: throw IllegalStateException("UsuariosRepository deve ser inicializado.")
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

    // Usuario:
    fun cadastrarUsuario(usuario: Usuario): Task<DocumentReference> {
        return colecaoUsuarios.add(usuario)
    }

    fun getUsuarios(): Task<QuerySnapshot> {
        return colecaoUsuarios.get()
    }

    fun getUsuariosColecao(): CollectionReference {
        return colecaoUsuarios
    }

    fun deleteUsuario(id: String) {
        colecaoUsuarios.document(id).delete()
    }

    fun atualizaUsuario(id: String?, usuario: Usuario) {
        if (id != null) {
            colecaoUsuarios.document(id).set(usuario)
        }
    }

    // Gastos:

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

    fun inscreverGastoEmUsuario(idUsuario: String, gastoComId: GastoComId){
        val gastoEmUsuario = GastoEmUsuario(
            nomeGasto = gastoComId.nomeGasto,
            cadastrarGasto() = gastoComId.categoria,
        )
        colecaoTurmas
            .document(idTurma)
            .collection("alunos")
            .document(alunoComId.id)
            .set(alunoNaTurma)
    }

}