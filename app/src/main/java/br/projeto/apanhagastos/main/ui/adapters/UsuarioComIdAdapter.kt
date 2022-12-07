package br.projeto.apanhagastos.main.ui.adapters
/*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.projeto.apanhagastos.models.UsuarioComId

class UsuarioComIdAdapter(val listener: UsuarioComIdListener) :
    ListAdapter<
            UsuarioComId,
            UsuarioComIdAdapter.ViewHolder
            >(UsuarioComIdDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent, listener)
    }

    class ViewHolder private constructor(
        val binding: UsuarioListItemBinding,
        val listener: UsuarioComIdListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UsuarioComId, position: Int) {
            binding.apply {
                usuarioNome.text = item.nomeUsuario
                usuarioProfessor.text = item.nomeProfessor
                usuarioHorario.text = item.horario

                ivEdit.setOnClickListener {
                    listener.onEditClick(item)
                }
                ivDelete.setOnClickListener {
                    listener.onDeleteClick(item)
                }

            }
        }

        companion object {
            fun from(parent: ViewGroup, listener: UsuarioComIdListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = UsuarioListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }

}


class UsuarioComIdDiffCallback : DiffUtil.ItemCallback<UsuarioComId>() {

    override fun areItemsTheSame(oldItem: UsuarioComId, newItem: UsuarioComId): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UsuarioComId, newItem: UsuarioComId): Boolean {
        return oldItem == newItem
    }
}


interface UsuarioComIdListener {
    fun onEditClick(usuario: UsuarioComId)
    fun onDeleteClick(usuario: UsuarioComId)
}
*/
