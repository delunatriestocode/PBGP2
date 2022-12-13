package br.projeto.apanhagastos.main.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.projeto.apanhagastos.databinding.GastoListItemBinding
import br.projeto.apanhagastos.models.GastoComId

class GastoComIdAdapter(val listener: GastoComIdListener) :
    ListAdapter<
            GastoComId,
            GastoComIdAdapter.ViewHolder
            >(GastoComIdDiffCallback()) {

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
        val listener: GastoComIdListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GastoComId, position: Int) {
            binding.apply {

                txtNomeGasto.text = item.nomeGasto
                txtCategoria.text = item.categoria
                txtValorGasto.text = item.custo.toString()
                var cor = ""
                when (item.categoria) {
                    "Saúde" -> cor = "#5EFF3F"
                    "Educação" -> cor = "#3FE7FF"
                    "Lazer" -> cor = "#00CF67"
                    "Mercado" -> cor = "#FF6E00"
                    "Alimentação" -> cor = "#FFA324"
                    "Contas" -> cor = "#0BB3FF"
                    "Dívidas" -> cor = "#FF3300"
                    else -> cor = "BEBEBE"
                }
                corCategoria.setBackgroundColor(Color.parseColor(cor))
                ivEdit.setOnClickListener {
                    listener.onEditClick(item)
                }
                ivDelete.setOnClickListener {
                    listener.onDeleteClick(item)
                }

            }
        }

        companion object {
            fun from(parent: ViewGroup, listener: GastoComIdListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GastoListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, listener)
            }
        }
    }

}


class GastoComIdDiffCallback : DiffUtil.ItemCallback<GastoComId>() {

    override fun areItemsTheSame(oldItem: GastoComId, newItem: GastoComId): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GastoComId, newItem: GastoComId): Boolean {
        return oldItem == newItem
    }
}


interface GastoComIdListener {
    fun onEditClick(gasto: GastoComId)
    fun onDeleteClick(gasto: GastoComId)
}