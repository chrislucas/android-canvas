package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.helper

import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.models.Department

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

fun providerComplexityStructureDepartment() = listOf(
    Department(
        1, null, 1, "department 1",
        listOf(
            Department(6, 1, 1, "sub-department 1:6"),
            Department(7, 1, 1, "sub-department 1:7"),
            Department(
                8, 1, 1, "sub-department 1:8",
                listOf(
                    Department(
                        10, 8, 1, "sub-department 8:10",
                        listOf(
                            Department(
                                21,
                                10,
                                1,
                                "sub-department 10:21",
                                listOf(
                                    Department(
                                        51,
                                        21,
                                        1,
                                        "sub-department 21:51",
                                        listOf(
                                            Department(
                                                52,
                                                51,
                                                1,
                                                "sub-department 51:52",
                                                listOf(
                                                    Department(
                                                        54,
                                                        52,
                                                        1,
                                                        "sub-department 52:54",
                                                        listOf(
                                                            Department(
                                                                59,
                                                                54,
                                                                1,
                                                                "sub-department 54:59",
                                                            )
                                                        )
                                                    ),
                                                    Department(
                                                        55,
                                                        52,
                                                        1,
                                                        "sub-department 52:55",
                                                        listOf(
                                                            Department(
                                                                60,
                                                                55,
                                                                1,
                                                                "sub-department 55:60",
                                                            )
                                                        )
                                                    ),
                                                    Department(
                                                        56,
                                                        52,
                                                        1,
                                                        "sub-department 52:56",
                                                        listOf(
                                                            Department(
                                                                61,
                                                                56,
                                                                1,
                                                                "sub-department 56:61",
                                                            )
                                                        )
                                                    )
                                                )
                                            ),
                                            Department(
                                                53,
                                                51,
                                                1,
                                                "sub-department 51:53",
                                            ),
                                        )
                                    ),
                                    Department(
                                        57,
                                        21,
                                        1,
                                        "sub-department 21:57",
                                    )
                                )
                            ),
                            Department(
                                58,
                                10,
                                1,
                                "sub-department 10:58",
                            )
                        )
                    ),
                    Department(11, 8, 1, "sub-department 8:11"),
                    Department(
                        12, 8, 1, "sub-department 8:12",
                        listOf(
                            Department(29, 12, 1, "sub-department 12:29"),
                            Department(30, 12, 1, "sub-department 12:30"),
                            Department(31, 12, 1, "sub-department 12:31"),
                            Department(
                                32, 12, 1, "sub-department 12:32",
                                listOf(
                                    Department(
                                        33, 32, 1,
                                        "sub-department 32:33"
                                    ),
                                    Department(
                                        34, 32, 1,
                                        "sub-department 32:34"
                                    ),
                                    Department(
                                        35, 32, 1,
                                        "sub-department 32:35"
                                    ),
                                    Department(
                                        36, 32, 1,
                                        "sub-department 32:36"
                                    )
                                )
                            )
                        )
                    ),
                )
            ),
            Department(
                9, 1, 1, "sub-department 1:9",
                listOf(
                    Department(13, 9, 1, "sub-department 9:13"),
                    Department(14, 9, 1, "sub-department 9:14"),
                    Department(15, 9, 1, "sub-department 9:15"),
                    Department(16, 9, 1, "sub-department 9:16"),
                )
            )
        )
    ),

    Department(
        2, null, 1, "department 2",
        listOf(
            Department(
                17, 2, 1, "sub-department 2:17",
                listOf(
                    Department(
                        22,
                        17,
                        1,
                        "sub-department 17:22",
                    ),

                    Department(
                        23,
                        17,
                        1,
                        "sub-department 17:23",
                    )
                )
            ),
            Department(
                18, 2, 1, "sub-department 2:18",
                listOf(
                    Department(
                        24,
                        18,
                        1,
                        "sub-department 18:24",
                        listOf(
                            Department(
                                26,
                                24,
                                1,
                                "sub-department 24:26",
                            )
                        )
                    ),

                    Department(
                        25,
                        18,
                        1,
                        "sub-department 18:25",
                    )
                )
            ),
        )
    ),

    Department(
        3, null, 1, "department 3",
        listOf(
            Department(
                18, 3, 1, "sub-department 3:18"
            ),
            Department(
                19, 3, 1, "sub-department 3:19",
                listOf(
                    Department(
                        39,
                        19,
                        1,
                        "sub-department 19:39",
                    )
                )
            ),
            Department(
                20, 3, 1, "sub-department 3:20",
                listOf(
                    Department(
                        38,
                        20,
                        1,
                        "sub-department 20:38",
                    )
                )
            ),
        )
    ),

    Department(
        4, null, 1, "department 4",
        listOf(
            Department(
                10, 4, 1, "sub-department 4:10",
                listOf(
                    Department(
                        37,
                        10,
                        1,
                        "sub-department 10:37",
                        listOf(
                            Department(
                                43,
                                10,
                                1,
                                "sub-department 10:43",
                            ),
                            Department(
                                44,
                                10,
                                1,
                                "sub-department 10:44",
                            )
                        )
                    ),
                    Department(
                        40,
                        10,
                        1,
                        "sub-department 10:40",
                        listOf(
                            Department(
                                41,
                                40,
                                1,
                                "sub-department 40:41",
                            ),
                            Department(
                                42,
                                40,
                                1,
                                "sub-department 40:42",
                                listOf(
                                    Department(
                                        45,
                                        40,
                                        1,
                                        "sub-department 40:45",
                                        listOf(
                                            Department(
                                                46,
                                                45,
                                                1,
                                                "sub-department 45:46",
                                            ),
                                            Department(
                                                47,
                                                45,
                                                1,
                                                "sub-department 45:47",
                                            ),
                                            Department(
                                                48,
                                                45,
                                                1,
                                                "sub-department 45:48",
                                                listOf(
                                                    Department(
                                                        50,
                                                        48,
                                                        1,
                                                        "sub-department 48:50",
                                                    ),
                                                )
                                            )
                                        )
                                    )
                                )
                            ),
                            Department(
                                48,
                                40,
                                1,
                                "sub-department 40:48",
                            )
                        )
                    ),
                    Department(
                        49,
                        10,
                        1,
                        "sub-department 10:49",
                    )
                )
            )
        )
    ),

    Department(
        5, null, 1, "department 5",
        listOf(
            Department(
                10,
                5,
                1,
                "sub-department 5:10",
                listOf(
                    Department(
                        27,
                        10,
                        1,
                        "sub-department 10:27",
                    )
                )
            ),
            Department(
                11,
                5,
                1,
                "sub-department 5:11",
                listOf(
                    Department(
                        28,
                        1,
                        1,
                        "sub-department 11:28",
                    )
                )
            )
        )
    )
)

internal fun mockDepartmentStructTree() =
    Department(
        0,
        null,
        1,
        "department 0",
        subDepartments = providerComplexityStructureDepartment(),
        subDepartmentName = "Nivel 0"
    )


fun titlePerLevelMock(key: Int) =
    mapOf(
        0 to "level 0",
        1 to "level 1",
        2 to "level 2",
        3 to "level 3",
        4 to "level 4",
    )[key] ?: "Undefined title level: $key"

