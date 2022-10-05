package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Department(
    @SerializedName("id_department") val id: Int,
    @SerializedName("id_department_parent") val parent: Int? = null,
    @SerializedName("resource_image") val resourceImage: Int,
    @SerializedName("description") val name: String,
    @SerializedName("sub_departments") val subDepartments: List<Department> = emptyList()
) : Parcelable {
    override fun toString(): String = "Name: $name | ID: $id"
}

