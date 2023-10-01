package com.example.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listdata)
        var list = arrayListOf<String>(
            "Amir",
            "Rashid",
            "Nomi",
            "Amir",
            "Rashid",
            "Nomi",
            "Amir",
            "Rashid",
            "Nomi",
            "Amir",
            "Rashid",
            "Nomi",
            "Amir",
            "Rashid",
            "Nomi"
        )
        var adaptor=Adaptor(applicationContext,list)

        var recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter=adaptor

    }
}