package com.example.arlibtest.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MedicationsService {

    @GET("v3/708d8436-9b0a-4528-a409-7a0011385bb5")
    fun getMedications(): Deferred<GetMedicationsResponse>
}