package com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.models

data class User(val name: String, val age: Int)


class ComparatorUserByAge : Comparator<User> {
    override fun compare(p: User, q: User): Int = p.age - q.age
}

class ComparatorUserByNameAscendant : Comparator<User> {
    override fun compare(p: User, q: User): Int = p.name.compareTo(q.name)
}