package com.example.arlibtest.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MedicationDao {

    @Query("SELECT * FROM databasemedication")
    fun getAllMedications(): LiveData<List<DatabaseMedication>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg medications: DatabaseMedication)

    @Query("DELETE FROM databasemedication")
    fun deleteAll()

}