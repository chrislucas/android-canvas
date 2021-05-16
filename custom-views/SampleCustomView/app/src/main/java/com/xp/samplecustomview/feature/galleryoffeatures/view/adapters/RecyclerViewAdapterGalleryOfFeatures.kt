package com.xp.samplecustomview.feature.galleryoffeatures.view.adapters

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.xp.samplecustomview.commons.view.recyclerview.action.SimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_UNDEFINED
import com.xp.samplecustomview.feature.galleryoffeatures.models.HolderBinderViewHolder


/**
 * A proposta deste adapter e deixar a responsabildade de construicao de cada item do recycler-view
 * para cada item da lista da propriedade "values". Cada item eh do tipo HolderLayoutOfFeatureList
 * um subtipo de LayoutBuilder uma interface que possui o metodo getViewType.
 *
 * Implementando getViewType, cada item da lista eh capaz de informar qual layout utilizar para
 * exibir os seus dados
 *
 * */
class RecyclerViewAdapterGalleryOfFeatures<T>(
    private val values: List<HolderBinderViewHolder<T>>,
    private val actionViewHolderSimple: SimpleBindViewHolder
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * viewType vem do metodo getItemViewType que por sua vez vai buscar na classe MODELO
     * (a lista values possui uma lista de modelos) que possui essa informacao.
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  actionViewHolderSimple.getViewHolder(viewType, parent)
    }

    override fun onViewAttachedToWindow(viewHolder: RecyclerView.ViewHolder) {
        if (viewHolder.absoluteAdapterPosition >= 0) {
            values[viewHolder.absoluteAdapterPosition].run {
                binder.onClick(viewHolder, this.item)
            }
        }
        super.onViewAttachedToWindow(viewHolder)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (values.isNotEmpty()) {
            values[position].run {
                binder.fillViewHolderWithData(holder, this.item)
            }
        }
    }

    override fun getItemCount(): Int = if (values.isEmpty()) 1 else values.size

    override fun getItemViewType(position: Int): Int = if (values.isNotEmpty()) {
        values[position].getItemViewType()
    } else {
        VIEW_HOLDER_UNDEFINED
    }


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        Log.i("ON_ATTACHED", "onAttachedToRecyclerView")
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.i("ON_DETACHED", "onDetachedFromRecyclerView")
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        Log.i("ON_VIEW_RECYCLED", "onViewRecycled")
    }

}