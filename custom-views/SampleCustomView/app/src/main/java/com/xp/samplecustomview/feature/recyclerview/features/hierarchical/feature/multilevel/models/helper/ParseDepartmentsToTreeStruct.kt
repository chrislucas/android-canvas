package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models

import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models.RecyclerViewSection
import java.util.*

internal fun createMapDepartment(departments: List<Department>): Map<Int, List<Department>> {
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

internal fun fromDepartmentsToSection(departments: List<Department>) {

    fun builder(department: Department, root: RecyclerViewSection<Department>, level: Int) {

    }

    val section = RecyclerViewSection(
        sectionName = "level 0",
        values = departments.toMutableList()
    )

    section.values.forEach { department->
        builder(department, section, 1)
    }
}


internal fun createDepartmentStruct(departments: List<Department>): DepartmentStruct {
    val tree = HashMap<Department, List<Department>>()
    val mapLevel = HashMap<Department, Int>()
    fun builder(
        department: Department,
        tree: HashMap<Department, List<Department>>,
        mapLevel: HashMap<Department, Int>,
        level: Int
    ) {
        mapLevel[department] = level
        if (department.subDepartments.isNotEmpty()) {
            val subDepartments = department.subDepartments
            tree[department] = subDepartments
            for (sub in subDepartments) {
                builder(sub, tree, mapLevel, level + 1)
            }
        }
    }
    departments.forEach { builder(it, tree, mapLevel, 0) }
    return DepartmentStruct(tree, mapLevel)
}


internal fun iterativeCreateTreeDepartmentStruct(departments: List<Department>)
        : Map<Pair<Int, Department>, List<Department>> {
    val tree = HashMap<Pair<Int, Department>, List<Department>>()
    val queue: Queue<Department> = LinkedList()
    queue += departments
    while (queue.isNotEmpty()) {
        queue.poll()?.let { current ->
            current.subDepartments
                .takeIf { it.isNotEmpty() }
                ?.let {
                    tree[Pair(current.id, current)] = it
                    queue += it
                }
        }
    }
    return tree
}
