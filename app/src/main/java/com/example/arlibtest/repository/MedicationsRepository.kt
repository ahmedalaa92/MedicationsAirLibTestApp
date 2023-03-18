package com.example.arlibtest.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.arlibtest.data.Medication
import com.example.arlibtest.database.MedicationDao
import com.example.arlibtest.database.asDataBaseModel
import com.example.arlibtest.database.asDomainModel
import com.example.arlibtest.network.Network
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class MedicationsRepository @Inject constructor(
    private val dao: MedicationDao
) {
    val medications: LiveData<List<Medication>> = Transformations.map(dao.getAllMedications()) {
        it.asDomainModel()
    }

    suspend fun refreshMedications() {
        withContext(Dispatchers.IO) {
            try {
                val medications = Network.medicationsService.getMedications().await()
                val medicationsList = medications.medicationsList
                dao.deleteAll()
                dao.insertAll(*medicationsList.asDataBaseModel())
            } catch (err: Exception) {
                Log.e("Failure", "failed to load medications: " + err.message.toString())
            }
        }
    }
}