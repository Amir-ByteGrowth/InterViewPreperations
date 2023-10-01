package com.example.interviewpreperations.broadcastmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.io.IOException


 val aLBReceiver: BroadcastReceiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // perform action here.
        try {
            Log.d("MyBroadCast",intent.extras?.getString("name").toString())
        }catch (exception:IOException){

        }
    }
}