package com.xp.samplecustomview.commons.view.recyclerview.action

import androidx.annotation.IntDef

@IntDef(
    VIEW_HOLDER_FEATURE_LIST_DEFAULT,
    VIEW_HOLDER_EMPTY_STATE
)
@Retention(AnnotationRetention.SOURCE)
annotation class ViewType

const val VIEW_HOLDER_EMPTY_STATE = 0
const val VIEW_HOLDER_FEATURE_LIST_DEFAULT = 1
const val VIEW_HOLDER_FEATURE_VIEW_BINDING_FRAGMENT = 2
const val VIEW_HOLDER_FEATURE_COLOR_OPTIONS = 3
const val VIEW_HOLDER_FEATURE_CUSTOM_VIEWS = 4
const val VIEW_HOLDER_UNDEFINED = 5