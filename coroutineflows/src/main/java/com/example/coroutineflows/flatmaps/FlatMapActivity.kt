package com.example.coroutineflows.flatmaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutineflows.R

class FlatMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frat_map)

//        MapFlatMapUtil.checkName()
//        MapFlatMapFilterUtil.filterToMethod()
//        MapFlatMapFilterUtil.filterIndexed()
//        MapFlatMapFilterUtil.filterInstance()

//        MapFlatMapFilterUtil.flatInList()
        MapFlatMapFilterUtil.flatMapTwoLists()
    }
}