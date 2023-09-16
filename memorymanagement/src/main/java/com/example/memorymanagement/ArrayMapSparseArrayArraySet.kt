package com.example.memorymanagement

import android.util.ArrayMap
import android.util.SparseArray


object ArrayMapSparseArrayArraySet {

    fun getArrayMap(): ArrayMap<Int, String> {

        var arrayMapOfStringInt = ArrayMap<Int, String>()
        arrayMapOfStringInt[1] = "A"
        arrayMapOfStringInt[2] = "B"
        arrayMapOfStringInt[3] = "C"


        return arrayMapOfStringInt
    }

    fun getSparseArray(): SparseArray<Int> {
        return SparseArray(4)
    }

}