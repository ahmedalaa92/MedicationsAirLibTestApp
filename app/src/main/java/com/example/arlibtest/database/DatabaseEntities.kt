package com.example.arlibtest.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseMedication constructor(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val dose: String,
    val strength: String
)