package com.example.bincard

import android.content.Context
import androidx.room.Room

class Core(
    private val context: Context
) {
    private val dataBase by lazy {
        Room.databaseBuilder(
            context,
            ItemsDataBase::class.java,
            "items_database"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    fun dao() = dataBase.itemsDao()
}