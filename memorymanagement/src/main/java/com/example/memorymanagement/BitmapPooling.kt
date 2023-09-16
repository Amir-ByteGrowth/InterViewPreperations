package com.example.memorymanagement

import android.graphics.BitmapFactory
import android.widget.ImageView


object BitmapPooling {
    fun bitmapPooling(imageview:ImageView){
        val bitmapOne = BitmapFactory.decodeFile("")
        imageview.setImageBitmap(bitmapOne)

        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile("", options)

        options.inMutable = true
        options.inBitmap = bitmapOne
        options.inJustDecodeBounds = false
        val bitmapTwo = BitmapFactory.decodeFile("", options)
        imageview.setImageBitmap(bitmapTwo)
    }
}