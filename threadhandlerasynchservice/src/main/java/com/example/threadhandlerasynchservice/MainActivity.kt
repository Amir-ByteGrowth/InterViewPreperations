package com.example.threadhandlerasynchservice

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    public var TAG = "ThreadMain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, (Looper.myLooper() == Looper.getMainLooper()).toString())
//        createNewThread()
        handler()

        var myThread = MyThread()
        myThread.start()

        AsyncTestClass().execute("Amir", "Rashid", "Nomi")
    }


    private fun createNewThread() {
        Thread {
            runOnUiThread {
                Toast.makeText(
                    applicationContext,
                    "NewThread Clicked",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d(TAG, Looper.myLooper().toString())
            }

            // accessing data from database or creating network call
        }.start()
    }

    private fun handler() {
        val handler = Handler()
        Thread { // accessing data from database or creating network call
            handler.post {

                Toast.makeText(applicationContext, "Task is Completed.", Toast.LENGTH_SHORT)
                    .show()
            }
        }.start()
    }


    class MyThread : Thread() {
        var TAG = "MYThread"
        override fun run() {
            super.run()


            Log.d(TAG, "MyThreadRunning")

        }
    }


    class AsyncTestClass : AsyncTask<String, String, String>() {
        var TAG = "AsyncTask"
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: String?): String {
            Log.d(TAG, "DoInAsycnBack")
            return "AsycnBack"
        }

        override fun onProgressUpdate(vararg values: String?) {

            super.onProgressUpdate(*values)
            Log.d(TAG, values.toString() + "OnProgressUpdate")
        }

        override fun onPostExecute(result: String?) {
            Log.d(TAG, result.toString() + "OnPostExecute")
            super.onPostExecute(result)
        }


    }


}