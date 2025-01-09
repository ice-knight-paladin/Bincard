package com.example.bincard.apii

import com.example.bincard.models.BankCardInfo

class BankCardRepository(private val api: BinApiService) {
    suspend fun getBankCardInfo(bin: String): BankCardInfo {
        return api.getBankCardInfo(bin)
    }
}