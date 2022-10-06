package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper

import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models.SectionStruct
import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.Department
import java.util.HashMap

// TODO remover

internal fun createHashMapDepartment(departments: List<Department>): Map<Department, List<Department>> {
    val tree = HashMap<Department, List<Department>>()
    fun builder(department: Department, map: HashMap<Department, List<Department>>) {
        if (department.subDepartments.isNotEmpty()) {
            map[department] = department.subDepartments
            for (sub in department.subDepartments) {
                builder(sub, map)
            }
        }
    }
    departments.forEach { builder(it, tree) }
    return tree
}

internal fun toMapSection(departments: List<Department>): Map<Int, SectionStruct<Department>> {
    val mapLevel = HashMap<Department, Int>()
    fun builder(
        department: Department,
        mapLevel: HashMap<Department, Int>,
        level: Int
    ) {
        mapLevel[department] = level
        if (department.subDepartments.isNotEmpty()) {
            for (subDepartments in department.subDepartments) {
                builder(subDepartments, mapLevel, level + 1)
            }
        }
    }

    departments.forEach { builder(it, mapLevel, 0) }
    val groupByLevel = hashMapOf<Int, SectionStruct<Department>>()
    mapLevel.forEach { (k, v) ->
        if (groupByLevel[v] == null) {
            groupByLevel[v] = SectionStruct(
                titlePerLevelMock(v),
                mutableListOf(k)
            )
        } else {
            val (name, list) = groupByLevel[v]!!
            groupByLevel[v] = SectionStruct(name, list + k)
        }
    }

    return groupByLevel
}