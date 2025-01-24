package com.hehc.roomsample.network

import com.hehc.roomsample.persistance.Starship

data class SWApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Starship>
)
