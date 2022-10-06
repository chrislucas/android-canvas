package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models

data class DepartmentStruct(
    val departmentStruct: Map<Department, List<Department>>,
    val departmentLevel: Map<Department, Int>
)