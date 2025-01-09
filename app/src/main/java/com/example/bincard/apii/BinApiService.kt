package com.example.bincard.apii

import android.util.Log
import com.example.bincard.models.BankCardInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApiService {
    @GET("{bin}")
    suspend fun getBankCardInfo(@Path("bin") bin: String): BankCardInfo

    companion object {
        private const val URL = "https://lookup.binlist.net/"

        fun create(): BinApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build()
            return retrofit.create(BinApiService::class.java)
        }
    }

}