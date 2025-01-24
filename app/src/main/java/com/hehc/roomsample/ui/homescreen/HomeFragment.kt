package com.hehc.roomsample.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.HomeFragmentBinding
import com.hehc.roomsample.persistance.Starship

class HomeFragment : Fragment(), OnStarshipClickedListener {

    private lateinit var binding: HomeFragmentBinding
    private val adapter by lazy { HomeScreenAdapter(this) }
    private val viewModel by lazy { HomeScreenViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        addStarships()
        observeData()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun observeData() {
        viewModel.ships.asLiveData().observe(viewLifecycleOwner) { ships ->
            adapter.loadStarships(ships)
        }
    }

    private fun addStarships() {
        viewModel.getStarships()
    }

    override fun onShipClicked(ship: Starship) {
        viewModel.saveStarship(ship)
    }
}
