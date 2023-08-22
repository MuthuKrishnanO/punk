package com.zoho.punk.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zoho.punk.Beer
import com.zoho.punk.BeerRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import kotlinx.coroutines.launch
class BeerViewModel(private val repository: BeerRepository) : ViewModel() {
    private val _beerList = MutableLiveData<List<Beer>>()
    val beerList: LiveData<List<Beer>> = _beerList

    fun fetchBeers() {

        viewModelScope.launch {
            try {
                val beers = repository.getBeers()
                _beerList.postValue(beers)
            } catch (e: Exception) {
                // Handle error appropriately
            }
        }
    }


}