package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models

data class DepartmentStruct(
    private val mappedDepartments: Map<Department, List<Department>>,
    private val departmentsLevel: Map<Department, Int>
) {
    fun getLevel(department: Department): Int? = departmentsLevel[department]

    fun getSubDepartments(department: Department): List<Department>? = mappedDepartments[department]
}