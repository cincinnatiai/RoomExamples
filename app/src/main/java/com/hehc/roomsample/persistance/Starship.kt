package com.hehc.roomsample.persistance

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Starship(
    @PrimaryKey
    val name: String,
    @ColumnInfo(name = "model")
    val model: String,
    @ColumnInfo(name = "manufacturer")
    val manufacturer: String,
    @ColumnInfo(name = "cost")
    @SerializedName("cost_in_credits")
    val costInCredits: String
)
