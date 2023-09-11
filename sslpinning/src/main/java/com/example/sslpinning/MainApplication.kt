package com.uae.myvaultspay

import android.app.Application
import android.content.Context
import com.uae.myvaultspay.data.remote.sumsub.PrefManager
import dagger.hilt.android.HiltAndroidApp
import com.squareup.picasso.Picasso

@HiltAndroidApp
class MainApplication : Application() {

    lateinit var prefManager: PrefManager

    companion object {
        var application: Application? = null
            private set
        val applicationContext: Context
            get() = application!!.applicationContext

        val PACKAGE_NAME: String
            get() = application!!.packageName


    }

    override fun onCreate() {
        super.onCreate()
        application = this

        Picasso.setSingletonInstance(Picasso.Builder(this).build())

        prefManager = PrefManager(this)
       // FirebaseApp.initializeApp(this)

    }
}