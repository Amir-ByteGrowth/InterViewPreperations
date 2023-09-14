package com.example.designpattren

import android.util.Log

interface Notification {
    abstract fun notifyUser()
}

class NotifyBySms : Notification {
    override fun notifyUser() {
        Log.d("NotifyUSer", "By Sms")
    }
}

class NotifyByEmail : Notification {
    override fun notifyUser() {
        Log.d("NotifyUSer", "By Email")
    }
}

class NotifyByCall : Notification {
    override fun notifyUser() {
        Log.d("NotifyUSer", "By Call")
    }
}

object NotificationFactory {
    fun createNotification(type: String): Notification {
        return when (type) {
            "sms" -> NotifyBySms()
            "email" -> NotifyByEmail()
            "call" -> NotifyByCall()
            else -> NotifyBySms()
        }

    }
}

fun main() {
//    NotificationFactory.createNotification("sms").notifyUser()
//    NotificationFactory.createNotification("email").notifyUser()
//    NotificationFactory.createNotification("call").notifyUser()

//    Log.d("Tag","Executed")
}