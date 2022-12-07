package br.projeto.apanhagastos.main.ui.adapters
/*

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.projeto.apanhagastos.models.Usuario

class UsuarioAdapter(val listener: UsuarioListener) :
    ListAdapter<
            Usuario,
            UsuarioAdapter.ViewHolder
            >(UsuarioDiffCallback()) {

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
        val listener: UsuarioListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Usuario, position: Int) {
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
            fun from(parent: ViewGroup, listener: UsuarioListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = UsuarioListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }

}


class UsuarioDiffCallback : DiffUtil.ItemCallback<Usuario>() {

    override fun areItemsTheSame(oldItem: Usuario, newItem: Usuario): Boolean {
        return oldItem.nomeUsuario == newItem.nomeUsuario
    }

    override fun areContentsTheSame(oldItem: Usuario, newItem: Usuario): Boolean {
        return oldItem == newItem
    }
}


interface UsuarioListener {
    fun onEditClick(usuario: Usuario)
    fun onDeleteClick(usuario:Usuario)
}
*/
