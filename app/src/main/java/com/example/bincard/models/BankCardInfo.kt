package com.example.bincard.models

data class BankCardInfo(
    val number: Number,
    val scheme: String,
    val brand: String,
    val type: String,
    val country: Country,
    val bank: Bank
)
