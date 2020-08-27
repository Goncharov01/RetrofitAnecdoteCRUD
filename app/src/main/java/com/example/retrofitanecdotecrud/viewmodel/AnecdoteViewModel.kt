package com.example.retrofitanecdotecrud.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitanecdotecrud.entity.Anecdote
import com.example.retrofitanecdotecrud.repository.AnecdoteRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class AnecdoteViewModel(private val repository: AnecdoteRepository) : ViewModel() {

    var isConnected: ObservableBoolean = ObservableBoolean(false)

    private var _anecdoteLiveData = MutableLiveData<List<Anecdote>>()
    val anecdoteLiveData: LiveData<List<Anecdote>> = _anecdoteLiveData

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.e("TAG", "CoroutineExceptionHandler got", exception)
    }

    private val scope = viewModelScope + handler + Dispatchers.Default

    fun showAnecdotes() {
        loadAnecdotesFromServer()
        Log.w("AnecdoteViewModel", "!!!!! showAnecdotes is run")
    }

    private fun loadAnecdotesFromServer() {
        scope.launch {
            repository.loadAndPutInDatabase()
        }

        Log.w("AnecdoteViewModel", "!!!!! loadAnecdotesFromServer is run")
    }

    fun getAllAnecdotes() {
        scope.launch {
            repository.getAnecdotes().collect {
                _anecdoteLiveData.postValue(it)
            }
        }

        Log.w("AnecdoteViewModel", "!!!!! getAllAnecdotes is run")
    }

}