package com.hehc.roomsample.ui.homescreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.ActivityMainBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = HomeScreenAdapter()
    private val viewModel = HomeScreenViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        addStarships()
        observeData()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun observeData() {
        viewModel.ships.asLiveData().observe(this) { ships ->
            adapter.loadStarships(ships)
        }
    }

    private fun addStarships() {
        viewModel.getStarships(listOf(1,2,3,4,5,6,7,8,9,10))
    }

    private fun setupSaveButton() {
        binding.saveButton.setOnClickListener {

        }
    }



}
