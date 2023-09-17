package com.example.recyclerviewimpl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      var recyclerView=  findViewById<RecyclerView>(R.id.recyclerView)
        var adaptor=HighPerformanceAdaptor(applicationContext,itemsDataClassList)
        recyclerView.adapter=adaptor
        val snapHelper = StartSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

    }
}