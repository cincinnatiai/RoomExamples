package com.hehc.roomsample.ui.homescreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.StarshipRowBinding
import com.hehc.roomsample.persistance.Starship

class HomeScreenAdapter(
    private val listener: OnStarshipClickedListener
) : RecyclerView.Adapter<HomeScreenViewHolder>() {

    private val starships = mutableListOf<Starship>()

    @SuppressLint("NotifyDataSetChanged")
    fun loadStarships(starships: List<Starship>) {
        this.starships.clear()
        this.starships.addAll(starships)
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

    override fun getItemCount(): Int = starships.size

    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) {
        val ship = starships[position]
        holder.bindModelToView(ship)
        holder.itemView.setOnClickListener {
            listener.onShipClicked(ship)
        }
    }
}

interface OnStarshipClickedListener {
    fun onShipClicked(ship: Starship)
}
