package com.example.trianglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            Toast.makeText(applicationContext,"1".toString(),Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            Toast.makeText(applicationContext,"2".toString(),Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btn3).setOnClickListener {
            Toast.makeText(applicationContext,"3".toString(),Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            Toast.makeText(applicationContext,"4".toString(),Toast.LENGTH_SHORT).show()
        }

    }
}