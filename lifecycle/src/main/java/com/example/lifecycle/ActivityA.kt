package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.Serializable

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)

        var bundle =Bundle()
    }
}

data class name(var name:String):Serializable