package com.example.bincard

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS `items_table` (`id` INTEGER NOT NULL, `text` TEXT NOT NULL, PRIMARY KEY(`id`))")
    }
}