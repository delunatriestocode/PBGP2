package br.projeto.apanhagastos.main.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.projeto.apanhagastos.models.Gasto
import br.projeto.apanhagastos.models.GastoComId
import br.projeto.apanhagastos.models.Usuario
import br.projeto.apanhagastos.models.UsuarioComId
import br.projeto.apanhagastos.repositories.AppRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.toObject

class MainViewModel : ViewModel() {

    val TAG = "ViewModel"
    val repository = AppRepository.get()

    fun getCurrentUserEmail(): String {
        return repository.getCurrentUser()?.email ?: "Email não encontrado"
    }

    fun logout() {
        repository.logout()
    }

    fun cadastrarUsuario(usuario: Usuario): Task<DocumentReference> {
        return repository.cadastrarUsuario(usuario)
    }

    // Ouvir vários documentos em uma coleção
    // https://firebase.google.com/docs/firestore/query-data/listen?hl=pt&authuser=0#listen_to_multiple_documents_in_a_collection
    fun observeColecaoUsuarios() {

        repository.getUsuariosColecao()
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w(TAG, "listen:error", e)
                    return@addSnapshotListener
                }

                val listaInput = mutableListOf<UsuarioComId>()

                val listaRemocao = mutableListOf<String>()

                val listaModificacao = mutableListOf<UsuarioComId>()

                // Ver alterações entre instantâneos
                // https://firebase.google.com/docs/firestore/query-data/listen?hl=pt&authuser=0#view_changes_between_snapshots
                for (dc in snapshots!!.documentChanges) {
                    when (dc.type) {

                        // Documento adicionado
                        DocumentChange.Type.ADDED -> {

                            val usuario = dc.document.toObject<Usuario>()
                            val id = dc.document.id
                            val usuarioComId = usuarioToUsuarioComId(usuario, id)

                            Log.i(TAG, "usuarioComId: ${usuarioComId}")
                            listaInput.add(usuarioComId)

                        }

                        // Documento modificado
                        DocumentChange.Type.MODIFIED -> {
                            val usuario = dc.document.toObject<Usuario>()
                            val id = dc.document.id
                            val usuarioComId = usuarioToUsuarioComId(usuario, id)

                            Log.i(TAG, "Modificacao - usuarioComId: ${usuarioComId}")
                            listaModificacao.add(usuarioComId)
                        }

                        // Documento removido
                        DocumentChange.Type.REMOVED -> {
                            val id = dc.document.id
                            Log.i(TAG, "id removido: ${id}")
                            listaRemocao.add(dc.document.id)

                        }
                    }
                }

                addListaToUsuariosComId(listaInput)
                removeFromUsuariosComId(listaRemocao)
                modifyInUsuariosComId(listaModificacao)
            }
    }

    fun modifyItemInListaUsuariosComId(itemModificado: UsuarioComId) {
        val listaAntiga = usuariosComId.value
        val listaNova = mutableListOf<UsuarioComId>()

        listaAntiga?.forEach { itemDaLista ->
            if (itemModificado.id == itemDaLista.id) {
                listaNova.add(itemModificado)
            } else {
                listaNova.add(itemDaLista)
            }
        }
        setUsuariosComId(listaNova)
    }

    private fun modifyInUsuariosComId(listaModificacao: List<UsuarioComId>) {
        Log.i(TAG, "listaModificacao: ${listaModificacao}")
        if (listaModificacao.isNotEmpty()) {
            for (itemModificado in listaModificacao) {
                modifyItemInListaUsuariosComId(itemModificado)
            }
        }
    }

    private fun removeFromUsuariosComId(listaRemocao: List<String>) {

        val listaAntiga = usuariosComId.value

        val listaNova = mutableListOf<UsuarioComId>()

        Log.i(TAG, "listaRemocao: ${listaRemocao}")

        if (listaRemocao.isNotEmpty()) {
            listaAntiga?.forEach {
                Log.i(TAG, "item da lista Antiga: ${it.id}")
                if (it.id in listaRemocao) {
                    Log.i(TAG, "item ${it.id} está dentro da listaRemocao")

                    //listaNova.add(it)
                } else {
                    Log.i(TAG, "item ${it.id} _NÃO_ está dentro da listaRemocao")

                    listaNova.add(it)
                }
            }
            setUsuariosComId(listaNova)
        }


    }

    fun addListaToUsuariosComId(listaInput: List<UsuarioComId>) {
        val listaAntiga = usuariosComId.value

        val listaNova = mutableListOf<UsuarioComId>()

        listaAntiga?.forEach {
            listaNova.add(it)
        }

        listaInput.forEach {
            listaNova.add(it)
        }

        setUsuariosComId(listaNova)


    }



    // Usuarios //////////////////////////////////////////////////////////////////////////////////////
    private val _usuarios = MutableLiveData<List<Usuario>>()
    val usuarios: LiveData<List<Usuario>> = _usuarios
    fun setUsuarios(value: List<Usuario>) {
        _usuarios.postValue(value)
    }

    private val _usuariosComId = MutableLiveData<List<UsuarioComId>>()
    val usuariosComId: LiveData<List<UsuarioComId>> = _usuariosComId
    fun setUsuariosComId(value: List<UsuarioComId>) {
        _usuariosComId.postValue(value)
    }

    fun usuarioToUsuarioComId(usuario: Usuario, id: String): UsuarioComId {
        return UsuarioComId(
            nomeUsuario = usuario.nome,
            email = usuario.email,
            id = id
        )
    }

    fun deleteUsuario(id: String) {
        repository.deleteUsuario(id)
    }

    private val _selectedUsuarioComId = MutableLiveData<UsuarioComId>()
    val selectedUsuarioComId: LiveData<UsuarioComId> = _selectedUsuarioComId
    fun setSelectedUsuarioComId(value: UsuarioComId) {
        _selectedUsuarioComId.postValue(value)
    }

    fun atualizaUsuario(usuario: Usuario) {
        repository.atualizaUsuario(selectedUsuarioComId.value?.id, usuario)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////



    // Gastos //////////////////////////////////////////////////////////////////////////////////////
    private val _gastosComId = MutableLiveData<List<GastoComId>>()
    val gastosComId: LiveData<List<GastoComId>> = _gastosComId
    fun setGastosComId(value: List<GastoComId>) {
        Log.i(TAG, "setGastosComId" )
        Log.i(TAG, "value = ${value}" )
        _gastosComId.postValue(value)
    }

    // Ouvir vários documentos em uma coleção
    // https://firebase.google.com/docs/firestore/query-data/listen?hl=pt&authuser=0#listen_to_multiple_documents_in_a_collection
    fun observeColecaoGastos() {

        repository.getGastosColecao()
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w(TAG, "listen:error", e)
                    return@addSnapshotListener
                }

                val listaInput = mutableListOf<GastoComId>()

                val listaRemocao = mutableListOf<String>()

                val listaModificacao = mutableListOf<GastoComId>()

                // Ver alterações entre instantâneos
                // https://firebase.google.com/docs/firestore/query-data/listen?hl=pt&authuser=0#view_changes_between_snapshots
                for (dc in snapshots!!.documentChanges) {
                    when (dc.type) {

                        // Documento adicionado
                        DocumentChange.Type.ADDED -> {

                            val gasto = dc.document.toObject<Gasto>()
                            val id = dc.document.id
                            val gastoComId = gastoToGastoComId(gasto, id)

                            Log.i(TAG, "gastoComId: ${gastoComId}")
                            listaInput.add(gastoComId)

                        }

                        // Documento modificado
                        DocumentChange.Type.MODIFIED -> {
                            val gasto = dc.document.toObject<Gasto>()
                            val id = dc.document.id
                            val gastoComId = gastoToGastoComId(gasto, id)

                            Log.i(TAG, "Modificacao - usuarioComId: ${gastoComId}")
                            listaModificacao.add(gastoComId)
                        }

                        // Documento removido
                        DocumentChange.Type.REMOVED -> {
                            val id = dc.document.id
//                            Log.i(TAG, "id removido: ${id}")
                            listaRemocao.add(dc.document.id)

                        }
                    }
                }

                addListaToGastosComId(listaInput)
                removeFromGastosComId(listaRemocao)
                modifyInGastosComId(listaModificacao)
            }
    }

    private fun gastoToGastoComId(gasto: Gasto, id: String): GastoComId {
        return GastoComId(
            nomeGasto = gasto.nomeGasto,
            categoria = gasto.categoria,
            custo = gasto.custo,
            id=id
        )
    }

    fun addListaToGastosComId(listaInput: List<GastoComId>) {

        val listaAntiga = gastosComId.value

        val listaNova = mutableListOf<GastoComId>()

        listaAntiga?.forEach {
            listaNova.add(it)
        }

        listaInput.forEach {
            listaNova.add(it)
        }

        setGastosComId(listaNova)
    }

    fun modifyItemInListaGastosComId(itemModificado: GastoComId) {
        val listaAntiga = gastosComId.value
        val listaNova = mutableListOf<GastoComId>()

        listaAntiga?.forEach { itemDaLista ->
            if (itemModificado.id == itemDaLista.id) {
                listaNova.add(itemModificado)
            } else {
                listaNova.add(itemDaLista)
            }
        }
        setGastosComId(listaNova)
    }

    private fun modifyInGastosComId(listaModificacao: List<GastoComId>) {
        Log.i(TAG, "listaModificacao: ${listaModificacao}")
        if (listaModificacao.isNotEmpty()) {
            for (itemModificado in listaModificacao) {
                modifyItemInListaGastosComId(itemModificado)
            }
        }
    }

    private fun removeFromGastosComId(listaRemocao: List<String>) {

        val listaAntiga = gastosComId.value

        val listaNova = mutableListOf<GastoComId>()

        Log.i(TAG, "listaRemocao: ${listaRemocao}")

        if (listaRemocao.isNotEmpty()) {
            listaAntiga?.forEach {
                Log.i(TAG, "item da lista Antiga: ${it.id}")
                if (it.id in listaRemocao) {
                    Log.i(TAG, "item ${it.id} está dentro da listaRemocao")

                    //listaNova.add(it)
                } else {
                    Log.i(TAG, "item ${it.id} _NÃO_ está dentro da listaRemocao")
                    listaNova.add(it)
                }
            }
            setGastosComId(listaNova)
        }


    }

    fun cadastrarGasto(gasto: Gasto): Task<DocumentReference> {
        return repository.cadastrarGasto(gasto)
    }

    private val _selectedGastoComId = MutableLiveData<GastoComId>()
    val selectedGastoComId: LiveData<GastoComId> = _selectedGastoComId
    fun setSelectedGastoComId(value: GastoComId) {
        _selectedGastoComId.postValue(value)
    }

    fun atualizaGasto(gasto: Gasto) {
        repository.atualizaGasto(selectedGastoComId.value?.id, gasto)
    }

    fun deleteGasto(gastoComId: GastoComId): Task<Void> {
        return repository.deleteGasto(gastoComId.id)
    }


    fun inscreverGastoNaUsuario(gastoComId: GastoComId){
        repository.inscreverGastoEmUsuario(
            selectedUsuarioComId.value?.id!!,
            gastoComId
        )
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    init {
        observeColecaoUsuarios()
        observeColecaoGastos()
    }


}