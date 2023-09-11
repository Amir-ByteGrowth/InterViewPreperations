package com.example.coroutineflows

import android.util.Log

object ListPartitionClass {
    data class User(val name: String, val id: Int, val isMentor: Boolean)

    var userList = listOf<User>(
        User("Amir", 1, true),
        User("Rashid", 1, true),
        User("Nomi", 1, false),
        User("Rabi", 1, false),
        User("Rehman", 1, false)
    )

    fun partitionList(){
        val(isMentor,noMentor)= userList.partition { it.isMentor }
        Log.d("Mentor",isMentor.toString())
        Log.d("NoMentor",isMentor.toString())
    }

}