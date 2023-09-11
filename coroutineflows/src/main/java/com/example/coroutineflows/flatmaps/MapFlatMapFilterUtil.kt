package com.example.coroutineflows.flatmaps

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

object MapFlatMapFilterUtil {
    data class Order(val lines: List<OrderLine>)
    data class OrderLine(val name: String, val price: Int)

    val order = Order(
        listOf(OrderLine("Tomato", 2), OrderLine("Garlic", 3), OrderLine("Chives", 2))
    )

    val names = order.lines.filter { it.name == "Tomato" }.map { it.name }

    fun checkName() {
        for (items in names) {
            Log.d("OrderName", items)
        }
    }


//    we can use the filterTo() function to append a List of elements matching the given predicate to the destination List:


    var listOfCountries = arrayListOf("Pakistan", "India", "Chinese", "Germany")
    var secondListOfCountries = arrayListOf("Nepolion", "Australia", "Japan", "Canada")
    fun filterToMethod() {
        listOfCountries.filterTo(secondListOfCountries) { it.length > 5 }

        for (item in secondListOfCountries) {
            Log.d("SecondCountryList", item)
        }
    }

    // filter indexed
    fun filterIndexed() {
        var countriesFilteredIndexed =
            listOfCountries.filterIndexed { index, item -> index != 3 && item.length > 5 }

        for (item in countriesFilteredIndexed) {
            Log.d("FilteredIndexed", item)
        }

    }


    // filter instance

    var mixData = arrayListOf("Amir", 1, "Rashid", 2, "Nomi", 3, "Abdul Rehman", 4)

    fun filterInstance() {
        GlobalScope.launch {
            mixData.filterIsInstance<Int>().asFlow()
                .onEach { Log.d("FilteredInstance", it.toString()) }.collect()

        }
    }

    //
//    map user data
    data class User(val name: String)
    data class Department(val name: String, val employees: List<User>)

    var departmentList = arrayListOf(
        Department(
            "Account", arrayListOf(
                User("Nomi"),
                User("Rashid"),
                User("Amir")
            )
        ),
        Department(
            "CS", arrayListOf(
                User("Mubbashar"),
                User("Imran"),
                User("Ahmad")
            )
        ),
        Department(
            "Finance", arrayListOf(
                User("Asad"),
                User("Saif"),
                User("Aziz")
            )
        )
    )

    var departmentListSecond = arrayListOf(
        Department(
            "Account1", arrayListOf(
                User("Nomi"),
                User("Rashid1"),
                User("AAmir1")
            )
        ),
        Department(
            "CS1", arrayListOf(
                User("Mubbashar1"),
                User("Imran1"),
                User("Ahmad1")
            )
        ),
        Department(
            "Finance1", arrayListOf(
                User("Asad1"),
                User("Saif1"),
                User("Aziz1")
            )
        )
    )

    fun flatInList() {

        var employees =
            departmentList.map { it.employees }.flatten()
        Log.d("EmployeeDetail", employees.toString())
    }

    /// flat map two lists
    var intList = arrayListOf("1", "2", "3", "4", "5")
    var strList = arrayListOf("A", "B", "C","D","E")

    fun flatMapTwoLists() {
        var combineList = intList.flatMap { strList }
        showData(combineList.toString())
    }

    fun showData(data: String) {
        Log.d("CheckingData", data)
    }

}