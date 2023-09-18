package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val constraints = Constraints.Builder()
//            .setRequiresDeviceIdle(true) //checks whether device should be idle for the WorkRequest to run
//            .setRequiresCharging(true) //checks whether device should be charging for the WorkRequest to run
            .setRequiredNetworkType(NetworkType.CONNECTED) //checks whether device should have Network Connection
            .setRequiresBatteryNotLow(true) // checks whether device battery should have a specific level to run the work request
            .setRequiresStorageNotLow(true) // checks whether device storage should have a specific level to run the work request
            .build()
        val workRequest = OneTimeWorkRequestBuilder<MyWorker>().setConstraints(constraints =constraints ).build()

        WorkManager.getInstance(applicationContext).enqueue(workRequest)


//        This will run every 1 hour periodically as we have set the period to be 1 hour.
        //we can set periodic request as this
//        val periodicWorkRequest =
//            PeriodicWorkRequestBuilder<MyWorker>(1, TimeUnit.HOURS)
//                .setConstraints(constraints)
//                .build()

//        Minimum time interval to run a periodic task is 15mins
//        If you do not want the task to be run immediately, you can specify your work to start after a minimum initial delay using,
//        val workRequest = OneTimeWorkRequestBuilder<MyWorker>()
//            .setInitialDelay(10, TimeUnit.MINUTES)
//            .build()

//
        WorkManager.getInstance(applicationContext).getWorkInfoByIdLiveData(workRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    //Toast
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
                }else if (workInfo.state==WorkInfo.State.FAILED){
                    Toast.makeText(applicationContext,"Failure",Toast.LENGTH_SHORT).show()
                }else if (workInfo.state==WorkInfo.State.ENQUEUED){
                    Toast.makeText(applicationContext,"Enqueued",Toast.LENGTH_SHORT).show()
                }else if (workInfo.state==WorkInfo.State.BLOCKED){
                    Toast.makeText(applicationContext,"Blocked",Toast.LENGTH_SHORT).show()
                }else if (workInfo.state==WorkInfo.State.RUNNING){
                    Toast.makeText(applicationContext,"RUNNING",Toast.LENGTH_SHORT).show()
                }else if (workInfo.state==WorkInfo.State.CANCELLED){
                    Toast.makeText(applicationContext,"CANCELLED",Toast.LENGTH_SHORT).show()
                }
            })

    }
}