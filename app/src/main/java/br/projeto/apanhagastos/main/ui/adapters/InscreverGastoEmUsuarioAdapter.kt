package br.projeto.apanhagastos.main.ui.adapters
/*

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.projeto.apanhagastos.models.GastoComId

class InscreverGastoEmUsuarioAdapter(val listener: InscreverGastoEmUsuarioListener) :
    ListAdapter<
            GastoComId,
            InscreverGastoEmUsuarioAdapter.ViewHolder
            >(InscreverGastoEmUsuarioDiffCallback()) {

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
        val binding: InscreverGastoEmUsuarioListItemBinding,
        val listener: InscreverGastoEmUsuarioListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GastoComId, position: Int) {
            binding.apply {

                gastoNome.text = item.nomeGasto
                matricula.text = item.matricula

                ivAdd.setOnClickListener{
                    listener.onAddClick(item)
                }

            }
        }

        companion object {
            fun from(parent: ViewGroup, listener: InscreverGastoEmUsuarioListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = InscreverGastoEmUsuarioListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }

}


class InscreverGastoEmUsuarioDiffCallback : DiffUtil.ItemCallback<GastoComId>() {

    override fun areItemsTheSame(oldItem: GastoComId, newItem: GastoComId): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GastoComId, newItem: GastoComId): Boolean {
        return oldItem == newItem
    }
}


interface InscreverGastoEmUsuarioListener {
    fun onAddClick(gasto: GastoComId)
}*/
