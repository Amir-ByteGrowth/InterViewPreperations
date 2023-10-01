package com.example.lifecycle


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LifeCycle","OnCreate")
//        startActivity(Intent(this@MainActivity,ActivityA::class.java))
//        finish()
//        replaceFragment()
    }

    fun replaceFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FragmentA.newInstance("Parameter 1","Parameter 2"))
        transaction.addToBackStack(null)
        transaction.commit()
    }



    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("LifeCycle","OnSavedInstanceState")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("LifeCycle","OnRestoreState")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle","OnRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle","OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle","OnResume")
    }


    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle","OnDestroy")
    }


}