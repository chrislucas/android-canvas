package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.viewholder.ViewHolderForRecyclerView
import kotlin.math.abs


typealias RVAdapter = RecyclerView.Adapter<out RecyclerView.ViewHolder>

class MultiLevelRecyclerViewAdapter<R : RVAdapter>(
    private val multiLevelStruct: MutableMap<Int, MultiLevelAdapterStruct<R>>
) : RecyclerView.Adapter<ViewHolderForRecyclerView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderForRecyclerView {
        return ViewHolderForRecyclerView.newInstance(parent)
    }

    override fun onBindViewHolder(
        viewHolderRecyclerView: ViewHolderForRecyclerView,
        position: Int
    ) {
        multiLevelStruct[position]?.let { adapterStruct ->
            viewHolderRecyclerView.recyclerView.let {
                it.adapter = adapterStruct.adapter
                it.layoutManager = adapterStruct.layoutManager
            }
            viewHolderRecyclerView.tvTitle.text = adapterStruct.title
        }
    }

    fun updateLevel(level: Int, data: MultiLevelAdapterStruct<R>) {
        multiLevelStruct[level] = data
        val diff = abs(multiLevelStruct.size - level)
        /*
            Seja V o nivel mais profundo que o usuario ja viu e U o nivel que ele selecionou
            se a diferenca entre U - V for maior que 1 eu so preciso mostrar para ele
            de 1 a U, os niveis U + 1 até V podem ser removidos pois so confundiram o usuário.

            Exemplo:
            Se o usuário tem a sua vista até subnível 5 e ele solicita ver os subniveis do nivel
            2, entao V = 5 U = 2. Mostramos de 1 a U e e de U + 1 a V deletamos para que ele
            ao selecionar algum item em U ele possa ver U + 1, U + 2, U + N ou quantos subníveis
            existirem
         */
        if (diff > 1) {
            notifyItemInserted(level)
            for (i in level + 1..multiLevelStruct.size) {
                multiLevelStruct.remove(i)
            }
            /*
                Começamos a deletar a partir de U + 1 e vamos até o ultimo nível V
                entao a quantidade é V - U + 1
             */
            notifyItemRangeRemoved(level + 1, diff + 1)
        }
        notifyItemChanged(level)

    }

    override fun getItemCount(): Int = multiLevelStruct.size

    class MultiLevelAdapterStruct<R : RVAdapter>(
        val adapter: R,
        val layoutManager: RecyclerView.LayoutManager,
        val title: String
    )
}

