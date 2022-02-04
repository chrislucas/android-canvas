package com.xp.samplecustomview.feature.recyclerview.samples.composite.models.sample

import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department

fun providerDepartments() = listOf(
    Department(
        1, null, 1, "department 1",
        listOf(
            Department(9, 1, 1, "sub-department 1:1"),
            Department(10, 1, 1, "sub-department 1:2"),
            Department(11, 1, 1, "sub-department 1:3"),
            Department(12, 1, 1, "sub-department 1:4"),
            Department(13, 1, 1, "sub-department 1:5"),
        )
    ),

    Department(
        2, null, 1, "department 2",
        listOf(
            Department(14, 2, 1, "sub-department 2:1"),
            Department(15, 2, 1, "sub-department 2:2"),
            Department(16, 2, 1, "sub-department 2:3"),
        )
    ),


    Department(
        3, null, 1, "department 3",
        listOf(
            Department(18, 3, 1, "sub-department 3:1"),
            Department(19, 3, 1, "sub-department 3:2"),
            Department(20, 3, 1, "sub-department 3:3"),
            Department(21, 3, 1, "sub-department 3:4"),
            Department(22, 3, 1, "sub-department 3:5"),
            Department(23, 3, 1, "sub-department 3:6"),
        )
    ),


    Department(
        4, null, 1, "department 4",
        listOf(
            Department(24, 4, 1, "sub-department 4:1"),
            Department(25, 4, 1, "sub-department 4:2"),
            Department(26, 4, 1, "sub-department 4:3"),
            Department(27, 4, 1, "sub-department 4:4"),
            Department(28, 4, 1, "sub-department 4:5"),
            Department(29, 4, 1, "sub-department 4:6"),
            Department(30, 4, 1, "sub-department 4:7"),
            Department(31, 4, 1, "sub-department 4:8"),
            Department(32, 4, 1, "sub-department 4:9"),
        )
    ),

    Department(
        5, null, 1, "department 5",
        listOf(
            Department(33, 5, 1, "sub-department 5:1"),
            Department(34, 5, 1, "sub-department 5:2"),
        )
    ),


    Department(
        6, null, 1, "department 6",
        listOf(
            Department(35, 6, 1, "sub-department 6:1")
        )
    ),


    Department(
        7, null, 1, "department 7",
        listOf(
            Department(1, 7, 1, "sub-department 7:1"),
            Department(1, 7, 1, "sub-department 7:2"),
            Department(1, 7, 1, "sub-department 7:3"),
            Department(1, 7, 1, "sub-department 7:4")
        )
    ),


    Department(
        8, null, 1, "department 8",
        listOf(
            Department(1, 8, 1, "sub-department 8:1"),
            Department(1, 8, 1, "sub-department 8:2"),
            Department(1, 8, 1, "sub-department 8:3"),
            Department(1, 8, 1, "sub-department 8:4")
        )
    )
)


fun providerComplexityStructureDepartment() = listOf<Department>()