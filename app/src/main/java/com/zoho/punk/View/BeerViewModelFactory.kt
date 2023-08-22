package com.zoho.punk.View

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zoho.punk.BeerRepository
import com.zoho.punk.ViewModel.BeerViewModel

class BeerViewModelFactory(private val repository: BeerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BeerViewModel::class.java)) {
            return BeerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}