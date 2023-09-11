package com.example.dependencyinjection

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencyinjection.hiltimplementationforinterface.UserInterface
import com.example.dependencyinjection.hiltimplementationforinterface.UserInterfaceSecond
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // Field Injection
    @Inject
    lateinit var simpleDependency: SimpleDependency

    @Inject
    lateinit var appModuleTestClass: AppModuleTestClass


    @ApplicationModule.ApiKey
    @Inject
    lateinit var apiKey: String

    @ApplicationModule.LibraryKey
    @Inject
    lateinit var libraryKey: String

    @Inject
    lateinit var listVal: ArrayList<String>

    @Inject
    lateinit var userInterface: UserInterface

    @Inject
    lateinit var userInterfaceSecond: UserInterfaceSecond

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        SimpleDependency(Engine(),Brand()).information()

        simpleDependency.information()

        findViewById<TextView>(R.id.tv).text = "$apiKey  $libraryKey \n injected IntVal${listVal.toString()}"

        appModuleTestClass.showApiKeys()

       Log.d("UserInterFace",userInterface.myFun())

        Log.d("UserInterFaceSecond",userInterfaceSecond.myFun())

        Log.d("UserInterFaceSecond",userInterfaceSecond.myFunSecond())
    }
}