package com.hehc.roomsample.ui.savedships

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hehc.roomsample.databinding.StarshipRowBinding
import com.hehc.roomsample.persistance.Starship


class PreferencesAdapter : RecyclerView.Adapter<PreferencesViewHolder>() {

    private val preferences = mutableListOf<Starship>()

    @SuppressLint("NotifyDataSetChanged")
    fun loadPreferences(starships: List<Starship>) {
        this.preferences.clear()
        this.preferences.addAll(starships)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreferencesViewHolder {
        return PreferencesViewHolder(
            StarshipRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = preferences.size

    override fun onBindViewHolder(holder: PreferencesViewHolder, position: Int) {
        holder.bindModelToView(preferences[position])
    }
}