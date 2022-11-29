package br.projeto.apanhagastos.main.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.projeto.apanhagastos.databinding.GastoListItemBinding
import br.projeto.apanhagastos.models.Gasto

class GastoAdapter (val listener: GastoListener) :
    ListAdapter<
            Gasto,
            GastoAdapter.ViewHolder
            >(GastoDiffCallback()) {

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
        val binding: GastoListItemBinding,
        val listener: GastoListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Gasto, position: Int) {
            binding.apply {
                txtNomeGasto.text = item.nome
                txtCategoria.text = item.categoria
                txtValorGasto.text = item.custo.toString()

                ivEdit.setOnClickListener {
                    listener.onEditClick(item)
                }
                ivDelete.setOnClickListener {
                    listener.onDeleteClick(item)
                }

            }
        }

        companion object {
            fun from(parent: ViewGroup, listener: GastoListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GastoListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }

}


class GastoDiffCallback : DiffUtil.ItemCallback<Gasto>() {

    override fun areItemsTheSame(oldItem: Gasto, newItem: Gasto): Boolean {
        return oldItem.nome == newItem.nome
    }

    override fun areContentsTheSame(oldItem: Gasto, newItem: Gasto): Boolean {
        return oldItem == newItem
    }
}


interface GastoListener {
    fun onEditClick(Gasto: Gasto)
    fun onDeleteClick(Gasto:Gasto)
}
