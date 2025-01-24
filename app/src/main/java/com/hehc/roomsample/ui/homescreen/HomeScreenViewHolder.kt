package com.hehc.roomsample.ui.homescreen

import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.StarshipRowBinding
import com.hehc.roomsample.persistance.Starship

class HomeScreenViewHolder(
    private val item: StarshipRowBinding
) : RecyclerView.ViewHolder(item.root) {

    fun bindModelToView(starship: Starship) {
        item.starshipName.text = starship.name
        item.starshipModel.text = starship.model
        item.starshipManufacturer.text = starship.manufacturer
        item.starshipCost.text = starship.costInCredits
    }
}

