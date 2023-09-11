package com.example.interviewpreperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.interviewpreperations.ui.main.Fragment

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Fragment.newInstance())
                .commitNow()

            Toast.makeText(applicationContext,"Clicked",Toast.LENGTH_SHORT).show()
        }
    }
}