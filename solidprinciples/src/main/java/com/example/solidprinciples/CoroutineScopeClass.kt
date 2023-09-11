package com.example.solidprinciples

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class CoroutineScopeClass {

    suspend fun getMoreUsers() {}
    suspend fun getUsers() {}

    fun checkCoroutingScope() {
        GlobalScope.launch {
            try {
                coroutineScope {
                    val usersDeferred = async { getUsers() }
                    val moreUsersDeferred = async { getMoreUsers() }
                    val users = usersDeferred.await()
                    val moreUsers = moreUsersDeferred.await()
                }
            } catch (exception: Exception) {
                Log.d("Main", "$exception handled !")
            }
        }
    }


    fun checkCoroutineScopeAgain() {
        GlobalScope.launch {
            try {
                coroutineScope {
                    val userDeferred = async {
                        getUsers()
                    }
                    val moreUserDeferred = async { getMoreUsers() }
                    val users = userDeferred.await()
                    val moreUsers = moreUserDeferred.await()
                }

            } catch (exception: Exception) {

            }
        }

    }

}