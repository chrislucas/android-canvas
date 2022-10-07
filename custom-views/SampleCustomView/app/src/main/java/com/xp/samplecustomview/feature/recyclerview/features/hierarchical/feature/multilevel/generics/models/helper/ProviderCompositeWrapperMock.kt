package com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models.helper

import com.xp.samplecustomview.feature.recyclerview.features.hierarchical.feature.multilevel.generics.models.CompositeWrapper


internal data class FakeData(val id: String, val name: String)


fun provideFakeCompositeSection() {
    CompositeWrapper(
        subSectionName = "Section 0",
        composition = listOf(
            CompositeWrapper(
                subSectionName = "Section 1",
                data = FakeData("#1", name = "data1#section1"),
                listOf(
                    CompositeWrapper(
                        subSectionName = "Section 2",
                        data = FakeData("#3", name = "data3#parent#1")
                    ),

                    CompositeWrapper(
                        subSectionName = "Section 2",
                        data = FakeData("#4", name = "data4#parent#1")
                    ),
                    CompositeWrapper(
                        subSectionName = "Section 2",
                        data = FakeData("#5", name = "data5#parent#1")
                    )
                )
            ),
            CompositeWrapper(
                subSectionName = "Section 1",
                data = FakeData("#2", name = "data2#section1"),
                listOf(
                    CompositeWrapper(
                        subSectionName = "Section 2",
                        data = FakeData("#6", "data6#parent#2"),
                        listOf(
                            CompositeWrapper(
                                subSectionName = "Section 3",
                                data = FakeData("#8", "data6#parent#2")
                            ),
                            CompositeWrapper(
                                subSectionName = "Section 3",
                                data = FakeData("#9", "data6#parent#2")
                            )
                        )
                    ),
                    CompositeWrapper(
                        subSectionName = "Section 2",
                        data = FakeData("#7", "data7#parent#2")
                    )
                )
            )
        )
    )
}