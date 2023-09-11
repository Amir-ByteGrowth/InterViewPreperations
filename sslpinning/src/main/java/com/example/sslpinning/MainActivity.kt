package com.example.sslpinning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// ssl pinning is implemented by two ways bye okkhttp client and retrofit
// or by xml network config file

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}