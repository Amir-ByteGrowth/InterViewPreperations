package com.example.designpattren.decoratorpattern.practice1

class UserRepositoryImpl :UserRepository {
    private val userList: MutableMap<String, String> =
        mutableMapOf("superman" to "Clark Kent", "batman" to "Bruce Wayne")
    override fun getUserName(userName: String): String? {
        return userList[userName]
    }

    override fun setUserName(userName: String, user: String) {
        userList[userName] = user
    }
}