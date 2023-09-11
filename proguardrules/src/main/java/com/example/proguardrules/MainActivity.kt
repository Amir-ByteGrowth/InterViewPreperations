package com.example.proguardrules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user=User(1,"Amir")
        val clien=Client(2,"Rashid")
        Log.d("UserName",user.name)
        Log.d("ClientName", clien.clientName)

    }
}