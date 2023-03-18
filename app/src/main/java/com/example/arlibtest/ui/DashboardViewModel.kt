package com.example.arlibtest.ui

import android.content.Context
import androidx.lifecycle.*
import com.example.arlibtest.getCurrentDayTime
import com.example.arlibtest.getGreetingWord
import com.example.arlibtest.repository.MedicationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    @ApplicationContext application: Context,
    private val medicationsRepository: MedicationsRepository
) : ViewModel() {

    private val _username = MutableLiveData<String>()

    private val _greetingWord = MediatorLiveData<String>().apply {
        addSource(_username) {
            this.value = String.format(
                getGreetingWord(application.applicationContext, getCurrentDayTime()), it
            )
        }
    }
    val greetingWord: LiveData<String>
        get() = _greetingWord

    val medicationsList = medicationsRepository.medications

    init {
        getMedicationsList()
    }

    fun setUserName(username: String) {
        _username.value = username
    }

    private fun getMedicationsList() {
        viewModelScope.launch {
            medicationsRepository.refreshMedications()
        }
    }

}