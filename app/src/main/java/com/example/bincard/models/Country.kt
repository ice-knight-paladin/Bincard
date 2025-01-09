package com.example.bincard.models

data class Country(
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Double,
    val longitude: Double
)
