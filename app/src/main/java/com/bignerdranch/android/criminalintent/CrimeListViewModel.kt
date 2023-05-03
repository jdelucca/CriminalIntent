package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID
private const val TAG = "CrimeListViewModel"
private val crimeRepository = CrimeRepository.get()

class CrimeListViewModel: ViewModel() {
    val crimes = mutableListOf<Crime>()
    
    init {
        Log.d(TAG, "init starting: ")
        viewModelScope.launch {
            Log.d(TAG, "coro launched: ")
            crimes +=loadCrimes()
            Log.d(TAG, "loading crimes finished: ")
        }
    }
    suspend fun loadCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }
}