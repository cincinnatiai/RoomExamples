package com.hehc.roomsample.ui.savedships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.PreferencesFragmentBinding
import com.hehc.roomsample.persistance.Starship


class PreferencesFragment : Fragment() {

    private lateinit var binding: PreferencesFragmentBinding
    private val adapter by lazy { PreferencesAdapter() }
    private val viewModel by lazy { PreferencesViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PreferencesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        getPreferences()
        observeData()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun observeData() {
        viewModel.preferences.asLiveData().observe(viewLifecycleOwner) { preferences ->
            handleDataChange(preferences)
        }
    }

    private fun handleDataChange(preferences: List<Starship>) {
        adapter.loadPreferences(preferences)
    }

    private fun getPreferences() {
        viewModel.getPreferences()
    }
}