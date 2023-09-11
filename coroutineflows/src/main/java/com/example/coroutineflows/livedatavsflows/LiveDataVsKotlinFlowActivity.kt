package com.example.coroutineflows.livedatavsflows

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutineflows.R
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManagerFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LiveDataVsKotlinFlowActivity : AppCompatActivity() {

    val liveDataViewModel: LiveDataViewModel = LiveDataViewModel()
    var counter = 0

    private var reviewInfo: ReviewInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_vs_kotlin_flow)
        liveDataViewModel.status.observe(this) {
            findViewById<TextView>(R.id.tvHi).text = it
        }



        liveDataViewModel.timerUpdate.observe(this) {
            findViewById<TextView>(R.id.tvHi).text = it
        }
//        liveDataViewModel.counter.start()


        GlobalScope.launch(Dispatchers.Main) {
            liveDataViewModel.flowTimer.collect {
                findViewById<TextView>(R.id.tvHi).text = it
            }
        }

        val manager = ReviewManagerFactory.create(applicationContext)
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                //Received ReviewInfo object
                reviewInfo = request.result
            } else {
                //Problem in receiving object
                reviewInfo = null
            }
        }


        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            liveDataViewModel.status.value = "amir" + counter++
            reviewInfo?.let {
                val flow = manager.launchReviewFlow(this@LiveDataVsKotlinFlowActivity, it)
                flow.addOnCompleteListener {
                    //Irrespective of the result, the app flow should continue
                    Log.d("Review", "Clicked")
                    if (it.isSuccessful) {
                        Log.d("ReviewStatus", "Success")
                    } else {
                        Log.d("ReviewStatus", "Failure")
                    }
                }
            }
        }

    }


    fun showFeedBackDialog() {
        val reviewManager = ReviewManagerFactory.create(applicationContext)
        reviewManager.requestReviewFlow().addOnCompleteListener {
            if (it.isSuccessful) {
                reviewManager.launchReviewFlow(this@LiveDataVsKotlinFlowActivity, it.result)
                    .addOnCompleteListener {

                    }
            }
        }

    }



}