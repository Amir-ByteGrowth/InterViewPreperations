package com.example.coroutineflows.lifecycletest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

// NetworkState.kt
fun changes(context: Context) = callbackFlow<Boolean> {

    val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
        addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)
    }
    val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val  action = intent.action
            Log.d("BrpadCastCalled","Being called")
            if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
                intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)
            }
        }
    }



    context.registerReceiver(broadcastReceiver, filter)

    awaitClose {
        context.unregisterReceiver(broadcastReceiver)
    }
}
// MyActivity.kt

