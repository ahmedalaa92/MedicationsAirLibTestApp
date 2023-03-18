package com.example.arlibtest.network

import com.example.arlibtest.data.Medication
import com.squareup.moshi.Json

data class GetMedicationsResponse(
    @Json(name = "medications") val medicationsList: List<Medication>
)
