package com.example.bincard

import com.example.bincard.apii.BankCardRepository
import com.example.bincard.apii.BinApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBinApiService(): BinApiService {
        return BinApiService.create()
    }

    @Provides
    fun provideBankCardRepository(api: BinApiService): BankCardRepository {
        return BankCardRepository(api)
    }
}