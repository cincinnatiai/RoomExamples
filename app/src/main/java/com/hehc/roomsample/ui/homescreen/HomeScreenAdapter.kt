package com.hehc.roomsample.ui.homescreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.StarshipRowBinding
import com.hehc.roomsample.persistance.Starship

class HomeScreenAdapter : RecyclerView.Adapter<HomeScreenViewHolder>() {

    private val _starships = mutableListOf<Starship>()

    fun loadStarships(starships: List<Starship>) {
        _starships.clear()
        _starships.addAll(starships)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenViewHolder {
        return HomeScreenViewHolder(
            StarshipRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = _starships.size

    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        holder.bindModelToView(_starships[position])
    }

}


