package com.example.designpattren

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.designpattren.dependencyinjectpattern.mainMethod

class MainActivity : AppCompatActivity() {
    var TAG = "DesignPattern"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var builderPattern = BuilderPattern.Builder("180").setBatter("120").create()
//        var builder2 = BuilderPattern(BuilderPattern.Builder("190"))
//        Log.d(TAG, builderPattern.getProcessor())
//        Log.d(TAG, builder2.getProcessor())
//
//
//
//        AlertDialog.Builder(this)
//            .setTitle("This is a title")
//            .setMessage("This is some message")
//            .show()
//
//        SingletonClass.showToast(applicationContext)

        mainMethod()

    }
}