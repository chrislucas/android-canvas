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
            Department(36, 7, 1, "sub-department 7:1"),
            Department(37, 7, 1, "sub-department 7:2"),
            Department(38, 7, 1, "sub-department 7:3"),
            Department(39, 7, 1, "sub-department 7:4")
        )
    ),


    Department(
        8, null, 1, "department 8",
        listOf(
            Department(40, 8, 1, "sub-department 8:1"),
            Department(41, 8, 1, "sub-department 8:2"),
            Department(42, 8, 1, "sub-department 8:3"),
            Department(
                43, 8, 1, "sub-department 8:4"
            )
        )
    )
)


fun providerComplexityStructureDepartment() = listOf<Department>(
    Department(
        1, null, 1, "department 1",
        listOf(
            Department(6, 1, 1, "sub-department 1:1"),
            Department(7, 1, 1, "sub-department 1:2"),
            Department(
                8,
                1,
                1,
                "sub-department 1:3",
                listOf(
                    Department(9, 8, 1, "sub-department 4:1"),
                    Department(10, 8, 1, "sub-department 4:2"),
                    Department(11, 8, 1, "sub-department 4:3"),
                )
            ),
            Department(
                5, 1, 1, "sub-department 1:4",
                listOf(
                    Department(6, 5, 1, "sub-department 5:1"),
                    Department(7, 5, 1, "sub-department 5:2"),
                    Department(8, 5, 1, "sub-department 5:3"),
                    Department(9, 5, 1, "sub-department 5:4"),
                )
            )
        )
    ),

    Department(
        2, null, 1, "department 2",
        listOf(
            Department(6, 1, 1, "sub-department 1:1", listOf()),
            Department(7, 1, 1, "sub-department 1:2", listOf()),
        )
    ),

    Department(
        3, null, 1, "department 2",
        listOf(
            Department(8, 1, 1, "sub-department 1:1", listOf()),
            Department(9, 1, 1, "sub-department 1:2", listOf()),
            Department(9, 1, 1, "sub-department 1:2", listOf()),
        )
    ),


    Department(
        4, null, 1, "department 2",
        listOf(
            Department(10, 1, 1, "sub-department 1:1", listOf())
        )
    ),

    Department(
        5, null, 1, "department 2",
        listOf(
            Department(10,
                1,
                1,
                "sub-department 1:1",
                listOf()
            ),
            Department(10,
                1,
                1,
                "sub-department 1:1",
                listOf())
        )
    )
)