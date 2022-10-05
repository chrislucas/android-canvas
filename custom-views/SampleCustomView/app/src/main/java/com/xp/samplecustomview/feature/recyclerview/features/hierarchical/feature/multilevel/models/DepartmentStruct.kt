package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models

data class DepartmentStruct(
    val departmentTree: Map<Department, List<Department>>,
    val level: Map<Department, Int>
)