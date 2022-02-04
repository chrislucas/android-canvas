package com.xp.samplecustomview.feature.recyclerview.samples.composite.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Department(
    @SerializedName("id_department") val id: Int,
    @SerializedName("id_department_parent") val parent: Int? = null,
    @SerializedName("resource_image") val resourceImage: Int,
    @SerializedName("description") val name: String,
    @SerializedName("sub_departments") val subDepartments: List<Department> = emptyList()
) : Parcelable