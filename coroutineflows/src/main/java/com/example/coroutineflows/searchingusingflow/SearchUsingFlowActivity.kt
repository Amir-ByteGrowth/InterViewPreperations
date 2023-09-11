package com.example.coroutineflows.searchingusingflow

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import com.example.coroutineflows.R
import com.example.coroutineflows.searchingusingflow.SearchViewExtention.dataFromNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SearchUsingFlowActivity : AppCompatActivity() , CoroutineScope {

    lateinit var searchView: SearchView
    lateinit var textViewResult:TextView

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_using_flow)
        searchView=findViewById(R.id.searchView)
        textViewResult=findViewById(R.id.textViewResult)

        job = Job()
        setUpSearchStateFlow()
    }
    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    private fun setUpSearchStateFlow() {
        launch {
            searchView.getQueryTextChangeStateFlow()
                .debounce(300)
                .filter { query ->
                    if (query.isEmpty()) {
                        textViewResult.text = ""
                        return@filter false
                    } else {
                        return@filter true
                    }
                }
                .distinctUntilChanged()
                .flatMapLatest { query ->
                    dataFromNetwork(query)
                        .catch {
                            emitAll(flowOf(""))
                        }
                }
                .flowOn(DefaultDispatcherProvider().default)
                .collect { result ->
                    textViewResult.text = result
                }
        }
    }

//    fun getLocationFlow(): Flow<Location> {
//        return callbackFlow {
//
//            val locationListener = LocationListener { location -> trySend(location) }
//
//            LocationManager.registerForLocation(locationListener)
//
//            awaitClose {
//                LocationManager.unregisterForLocation(locationListener)
//            }
//
//        }
//    }

}