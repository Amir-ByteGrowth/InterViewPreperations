package com.example.designpattren.decoratorpattern.practice1

interface UserRepository {
    fun getUserName(userName:String):String?
    fun setUserName(userName: String,user: String)
}