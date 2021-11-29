package com.xp.samplecustomview.feature.galleryoffeatures.models

import com.xp.samplecustomview.commons.view.recyclerview.action.ProviderViewTypeForViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ViewType
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.actions.BindDataToViewHolder

/*
    classe composto por um item e uma interface responsável por
    definir o comportamento de um elemento num recyclerview quando o usuário
    interagir com um item da lista
        - Interagindo com um texto, imagem, o próprio item ou qualquer outro elemento visual
        que compreende o item da lista, podemos definir um comportamento
        - Essa interface tambem tem a responsabilidade de definir como a interface gráfica será
        preenchida
 */

class CompositeRecyclerViewItem<T>(
    @ViewType val viewType: Int,
    val item: T,
    val binder: BindDataToViewHolder<T>
) : ProviderViewTypeForViewHolder {
    override fun getItemViewType(): Int = viewType
}
