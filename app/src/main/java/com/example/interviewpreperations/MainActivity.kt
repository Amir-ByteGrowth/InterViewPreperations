package com.example.interviewpreperations

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.interviewpreperations.broadcastmanager.aLBReceiver


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LocalBroadcastManager.getInstance(this).registerReceiver(aLBReceiver,
             IntentFilter("anEvent")
        );

        val intent = Intent("anEvent")
        intent.putExtra("name", "This is an event")
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }


    override fun onPause() {
        super.onPause()
        // Unregister since the activity is about to be closed.
        LocalBroadcastManager.getInstance(this).unregisterReceiver(aLBReceiver)
        super.onDestroy()
    }

}