package com.example.coroutineflows.searchingusingflow

import androidx.appcompat.widget.SearchView
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

object SearchViewExtention {
    var counter = 0
    fun dataFromNetwork(query: String): Flow<String> {
        return flow {
            delay(2000)
            emit("$query data from network  " + (counter++))
        }
    }
}

fun SearchView.getQueryTextChangeStateFlow(): StateFlow<String> {

    val query = MutableStateFlow("")

    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String): Boolean {
            query.value = newText
            return true
        }
    })

    return query

}