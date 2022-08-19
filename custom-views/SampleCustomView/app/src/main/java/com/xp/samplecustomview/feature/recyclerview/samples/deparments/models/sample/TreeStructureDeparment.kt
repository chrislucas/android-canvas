package com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.sample

import com.xp.samplecustomview.feature.recyclerview.samples.deparments.models.Department
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

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

internal fun createTreeDepartmentStruct(departments: List<Department>) : Map<Department, List<Department>> {
    val tree = HashMap<Department, List<Department>>()
    fun builder(department: Department?, map: HashMap<Department, List<Department>>) {
        department?.let {
            if (it.subDepartments.isNotEmpty()) {
                map[it] = it.subDepartments
                for (sub in it.subDepartments) {
                    builder(sub, map)
                }
            }
        }
    }

    departments.forEach { builder(it, tree) }
    return tree
}


/**
 * TODO implementar um algoritmo iterativo
 *
 */
internal fun tree(departments: List<Department>) : Map<Department, List<Department>> {
    val tree = TreeMap<Department, List<Department>>()
    val queue : Queue<Department> = LinkedList()
    while (queue.isNotEmpty()) {

    }
    return tree
}
