package br.projeto.apanhagastos.repositories

import br.projeto.apanhagastos.models.Categoria
import br.projeto.apanhagastos.models.Gasto
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



const val TAG = "CategoriasFirebase"

class CategoriasRepository private constructor() {


// Inicialização do Firebase Auth:

    companion object {

        lateinit var auth: FirebaseAuth

        lateinit var db: FirebaseFirestore

        lateinit var colecaoCategorias : CollectionReference

        lateinit var colecaoGastos : CollectionReference

        private var INSTANCE: CategoriasRepository? = null
        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = CategoriasRepository()
            }
            auth = Firebase.auth
            // Banco de dados Firestore
            db = Firebase.firestore

            // Coleção de categorias:
            colecaoCategorias = db.collection("categorias")

            // Coleção de gastos:
            colecaoGastos = db.collection("gastos")

        }

        fun get(): CategoriasRepository {
            return INSTANCE
                ?: throw IllegalStateException("CategoriasRepository deve ser inicializado.")
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

    // Categorias:
    fun cadastrarCategoria(categoria: Categoria): Task<DocumentReference> {
        return colecaoCategorias.add(categoria)
    }

    fun getCategorias(): Task<QuerySnapshot> {
        return colecaoCategorias.get()
    }

    fun getCategoriasColecao(): CollectionReference {
        return colecaoCategorias
    }

    fun deleteCategoria(id: String) {
        colecaoCategorias.document(id).delete()
    }

    fun atualizaCategoria(id: String?, categoria: Categoria) {
        if (id != null) {
            colecaoCategorias.document(id).set(categoria)
        }
    }

    // Gastos:

    fun getGastosColecao(): CollectionReference {
        return colecaoGastos
    }

    fun cadastrarAluno(gasto: Gasto): Task<DocumentReference> {
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
/*
    fun inscreverAlunoNaTurma(idTurma: String, alunoComId: AlunoComId){
        val alunoNaTurma = GastoEmCategoria(
            nomeAluno = alunoComId.nomeAluno,
            matricula = alunoComId.matricula,
        )
        colecaoCategorias
            .document(idTurma)
            .collection("alunos")
            .document(alunoComId.id)
            .set(alunoNaTurma)
    }
*/

}