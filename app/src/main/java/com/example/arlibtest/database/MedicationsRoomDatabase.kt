package com.example.arlibtest.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DatabaseMedication::class], version = 1, exportSchema = false)
abstract class MedicationsRoomDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao

}