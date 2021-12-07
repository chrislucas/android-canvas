package com.xp.samplecustomview.commons.view.recyclerview.action

import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

/**
    interface que representa um comportamento ao interagir com um item
    de um recyclerview que contém algum fragment que implementa o a interface
 *  @see BaseBehaviorFragment
 *  O objetivo eh recuperar esse fragment que o item encapsula e tomar alguma decisao.
 *  Geralmente é carregar o fragment
 */
interface ListenerListFragmentsViewHolder {
    fun onInteractWithView(behaviorFragment: BaseBehaviorFragment)
}