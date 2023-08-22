package com.zoho.punk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zoho.punk.View.BeerViewModelFactory
import com.zoho.punk.ViewModel.BeerViewModel
import com.zoho.punk.adapter.BeerListAdapter

class BeerListActivity : AppCompatActivity() {
    private lateinit var viewModel: BeerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer_list)

        val repository = BeerRepository()
        viewModel = ViewModelProvider(this, BeerViewModelFactory(repository))
            .get(BeerViewModel::class.java)



        val beerListAdapter = BeerListAdapter()

        val beerRecyclerView: RecyclerView = findViewById(R.id.beerRecyclerView)
        beerRecyclerView.layoutManager = LinearLayoutManager(this)
        beerRecyclerView.adapter = beerListAdapter

        viewModel.beerList.observe(this, { beers ->
            beerListAdapter.submitList(beers)
        })

        val refreshButton: Button = findViewById(R.id.refreshButton)
        refreshButton.setOnClickListener {
            viewModel.fetchBeers()
        }
    }
}
