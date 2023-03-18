package com.example.arlibtest.database

import com.example.arlibtest.data.Medication

fun List<DatabaseMedication>.asDomainModel(): List<Medication> {
    return map {
        Medication(
            name = it.name, dose = it.dose, strength = it.strength
        )
    }
}

fun List<Medication>.asDataBaseModel(): Array<DatabaseMedication> {
    return map {
        DatabaseMedication(
            name = it.name, dose = it.dose, strength = it.strength
        )
    }.toTypedArray()
}

