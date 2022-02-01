package com.xp.samplecustomview.feature.recyclerview.samples.composite.models.sample

import com.xp.samplecustomview.feature.recyclerview.samples.composite.models.Department

fun providerDepartments() = listOf(
    Department(
        1, null, 1, "department 1",
        listOf(
            Department(9, 1, 1, "description 1:1"),
            Department(10, 1, 1, "description 1:2"),
            Department(11, 1, 1, "description 1:3"),
            Department(12, 1, 1, "description 1:4"),
            Department(13, 1, 1, "description 1:5"),
        )
    ),

    Department(
        2, null, 1, "department 2",
        listOf(
            Department(14, 2, 1, "description 2:1"),
            Department(15, 2, 1, "description 2:2"),
            Department(16, 2, 1, "description 2:3"),
        )
    ),


    Department(
        3, null, 1, "department 3",
        listOf(
            Department(1, 3, 1, "description 3:1"),
            Department(1, 3, 1, "description 3:2"),
            Department(1, 3, 1, "description 3:3"),
            Department(1, 3, 1, "description 3:4"),
            Department(1, 3, 1, "description 3:5"),
            Department(1, 3, 1, "description 3:6"),
        )
    ),


    Department(
        4, null, 1, "department 4",
        listOf(
            Department(1, 4, 1, "description 4:1"),
            Department(1, 4, 1, "description 4:2"),
            Department(1, 4, 1, "description 4:3"),
            Department(1, 4, 1, "description 4:4"),
            Department(1, 4, 1, "description 4:5"),
            Department(1, 4, 1, "description 4:6"),
            Department(1, 4, 1, "description 4:7"),
            Department(1, 4, 1, "3, 1,description 4:8"),
            Department(1, 4, 1, "description 4:9"),
        )
    ),

    Department(
        5, null, 1, "department 5",
        listOf(
            Department(1, 5, 1, "description 5:1"),
            Department(1, 5, 1, "description 5:2"),
        )
    ),


    Department(
        6, null, 1, "department 6",
        listOf(
            Department(1, 6, 1, "description 6:1")
        )
    ),


    Department(
        7, null, 1, "department 7",
        listOf(
            Department(1, 7, 1, "description 7:1"),
            Department(1, 7, 1, "description 7:2"),
            Department(1, 7, 1, "description 7:3"),
            Department(1, 7, 1, "description 7:4")
        )
    ),


    Department(
        8, null, 1, "department 8",
        listOf(
            Department(1, 8, 1, "description 8:1"),
            Department(1, 8, 1, "description 8:2"),
            Department(1, 8, 1, "description 8:3"),
            Department(1, 8, 1, "description 8:4")
        )
    )
)