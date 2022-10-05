package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Selector(
    @SerializedName("id_selector") val id: Int,
    @SerializedName("selector_parent") val parent: Selector? = null,
    @SerializedName("description") val name: String,
    @SerializedName("sub_departments") val option: List<Selector>?
) : Parcelable


@Parcelize
class Item(
    @SerializedName("id_selector") val id: Int,
    @SerializedName("selector_parent") val parent: Item? = null,
    @SerializedName("description") val name: String,
    @SerializedName("sub_departments") val options: Item?
) : Parcelable