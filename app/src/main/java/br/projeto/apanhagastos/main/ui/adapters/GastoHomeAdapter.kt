package br.projeto.apanhagastos.main.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.projeto.apanhagastos.databinding.GastoListItemBinding
import br.projeto.apanhagastos.databinding.GastoListItemHomeBinding
import br.projeto.apanhagastos.models.GastoComId

class GastoHomeAdapter() :
    ListAdapter<
            GastoComId,
            GastoHomeAdapter.ViewHolder
            >(GastoComIdDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(
        val binding: GastoListItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GastoComId, position: Int) {
            binding.apply {

                txtNomeGasto.text = item.nomeGasto
                txtCategoria.text = item.categoria
                txtValorGasto.text = item.custo.toString()
                /*var cor = ""
                when (item.categoria) {
                    "Lazer" -> cor = "#00cf67"
                    "Educação" -> cor = "#3fe7ff"
                    else -> cor = "FFFFFF"
                }
                corCategoria.setBackgroundColor(Color.parseColor(cor))*/

            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GastoListItemHomeBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding)
            }
        }
    }

}


class GastoHomeDiffCallback : DiffUtil.ItemCallback<GastoComId>() {

    override fun areItemsTheSame(oldItem: GastoComId, newItem: GastoComId): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GastoComId, newItem: GastoComId): Boolean {
        return oldItem == newItem
    }
}
