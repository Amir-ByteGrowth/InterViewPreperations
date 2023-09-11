package com.example.coroutineflows.lifecycletest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.coroutineflows.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LifeCycleTestActivity : AppCompatActivity() {

    private lateinit var viewModel: LifeCycleTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_test)
        Log.d("LifeCycleState", "OnCreate")
        setupViewModel()
        setupObserver()
//        safeFlowObserving()
        findViewById<Button>(R.id.btnGoToNext).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }


    }

//    init {
//        lifecycle.coroutineScope.launchWhenStarted {
//            changes(applicationContext)
//                .onEach { isConnected -> Log.d("WifiConnection","BeingCalled")}
//                .launchIn(this)
//        }
//    }

    init {
        lifecycle.launchRestartable(
            jobsLifetime = Lifecycle.Event.ON_START..Lifecycle.Event.ON_STOP,
            unsubscribeOn = Lifecycle.Event.ON_DESTROY
        ) {
            changes(applicationContext)
                .onEach { isConnected -> Log.d("WifiConnection", "BeingCalled") }
                .launchIn(this)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycleState", "OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycleState", "OnRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycleState", "OnStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycleState", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        job.cancel()
        Log.d("LifeCycleState", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("LifeCycleState", "OnDestroy")
    }


//    this way is not stopping listening even app go to background or stop stated, so we have to make some changes go to next function
lateinit var job: Job
//we can also stop collecting data when we cancel job mannualy on stop method as i get job refrence and cancel it on stop method it get restarted when we come on screen

    private fun setupObserver() {
      job=  lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            Log.d("UiStateCase", "Success   $it")
                        }

                        is UiState.Loading -> {
                            Log.d("UiStateCase", "Loading   $it")
                        }

                        is UiState.Error -> {
                            //Handle Error
                            findViewById<Button>(R.id.btnGoToNext).text = it.message
                            Toast.makeText(applicationContext,it.message,Toast.LENGTH_SHORT).show()
                            Log.d("UiStateCase", "Error   $it")
                        }
                    }
                }
            }
        }
    }

    fun safeFlowObserving() {
        lifecycle.launchRestartable(
            jobsLifetime = Lifecycle.Event.ON_START..Lifecycle.Event.ON_STOP,
            unsubscribeOn = Lifecycle.Event.ON_DESTROY
        ) {
            viewModel.uiState.collect {
                when (it) {
                    is UiState.Success -> {
                        Log.d("UiStateCase", "Success   $it")
                        findViewById<TextView>(R.id.tvRandomCheck).text="Success $it"
                        Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Loading -> {
                        Log.d("UiStateCase", "Loading   $it")
                    }

                    is UiState.Error -> {
                        //Handle Error
                        findViewById<Button>(R.id.btnGoToNext).text = it.message
                        Toast.makeText(applicationContext,it.message,Toast.LENGTH_SHORT).show()
                        Log.d("UiStateCase", "Error   $it")
                    }
                }
            }
        }
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this
        )[LifeCycleTestViewModel::class.java]
    }

}