package com.example.workmanager

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Delay
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


const val SAVED_INT_KEY = "int_key";

class MyWorker(var appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {


    lateinit var task: CounterTask

    override fun doWork(): Result {
        // Your work here.
//        var counterTask=CounterTask(this, 0)
//        GlobalScope.launch {
//           var a= counterTask.execute()
//        }

     Thread.sleep(15000)

        // Your task result
        return Result.success()
    }

    private fun getValue(): Int {
        val prefs = appContext.getSharedPreferences("deep_service", Context.MODE_PRIVATE)
        // Try to fetch a preference.
        val start = prefs.getInt(SAVED_INT_KEY, 0)
        return start
    }

    class CounterTask(private val params: MyWorker, var startInt: Int) :
        AsyncTask<Unit, Int, Unit>() {
        private val LIMIT = 100
        private var start = 0

        override fun onPreExecute() {
            super.onPreExecute()
            // Pick the last value which was saved in the last execution and continue from there.
            start = params.getValue()
        }

        override fun doInBackground(vararg params: Unit?) {
            for (i in start..LIMIT) {
                if (!isCancelled) {         // Execute only if job is not cancelled. on every
                    // stopJob() we will cancel this CounterTask
                    Thread.sleep(400)
                    if (startInt < LIMIT) {
                        publishProgress(startInt++)
                    }
                }
            }
        }

        // Write the completed status after each work is finished.
        override fun onProgressUpdate(vararg values: Int?) {
            Log.d(MyWorker::class.java.simpleName, "Counter value: ${values[0]}")
            val prefs = params.appContext.getSharedPreferences("deep_service", Context.MODE_PRIVATE)
            // Try to fetch a preference and add current progress.
            values[0]?.let { prefs.edit().putInt(SAVED_INT_KEY, it).commit() }
        }

        // Once job is finished, reset the preferences.
        override fun onPostExecute(result: Unit?) {

        }
    }

}