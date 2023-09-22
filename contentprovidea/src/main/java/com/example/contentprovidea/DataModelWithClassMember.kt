package com.example.contentprovidea

data class DataModelWithClassMember(val id: Int, val name: String) {
    var idName = "" + id + name
}


val listItems = arrayListOf(
    DataModelWithClassMember(1, "a"),
    DataModelWithClassMember(2, "b"),
    DataModelWithClassMember(3, "c"),
    DataModelWithClassMember(4, "d"),
    DataModelWithClassMember(5, "e")
)
