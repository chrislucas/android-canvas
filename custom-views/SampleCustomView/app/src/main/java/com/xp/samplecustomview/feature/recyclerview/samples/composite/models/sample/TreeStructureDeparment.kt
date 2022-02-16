package com.xp.samplecustomview.feature.recyclerview.samples.composite.models.sample

import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department

internal fun toTreeStructure(departments: List<Department>): Map<Int, List<Department>> {

    val tree = linkedMapOf<Int, List<Department>>()

    fun builder(department: Department?, map: LinkedHashMap<Int, List<Department>>) {
        if (department == null) {
            return
        } else {
            if (department.subDepartments.isNotEmpty()) {
                map[department.id] = department.subDepartments
                for (subDepartment in department.subDepartments) {
                    builder(subDepartment, map)
                }
            }
        }
    }
    departments.forEach { builder(it, tree) }
    return tree
}