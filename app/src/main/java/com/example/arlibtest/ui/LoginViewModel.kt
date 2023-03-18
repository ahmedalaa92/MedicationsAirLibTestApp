package com.example.arlibtest.ui

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class LoginViewModel : ViewModel() {

    val usernameText = MutableLiveData<String>()
    val passwordText = MutableLiveData<String>()

    private val _usernameTextFieldEmpty = MutableLiveData(false)
    val usernameTextFieldEmpty: LiveData<Boolean>
        get() = _usernameTextFieldEmpty

    private val _passwordTextFieldEmpty = MutableLiveData(false)
    val passwordTextFieldEmpty: LiveData<Boolean>
        get() = _passwordTextFieldEmpty

    private var _navigationToDashboard = MutableLiveData(false)
    val navigationToDashboard: LiveData<Boolean>
        get() = _navigationToDashboard

    fun onSignInButtonClicked() {
        if (validateUsernameAndPassword()) {
            _navigationToDashboard.value = true
        }
    }

    fun onNavigationToDashboardDone() {
        _navigationToDashboard.value = false
    }

    fun validateUsernameAndPassword(): Boolean {
        var isValid = true
        if (TextUtils.isEmpty(usernameText.value)) {
            isValid = false
            _usernameTextFieldEmpty.value = true
        }
        if (TextUtils.isEmpty(passwordText.value)) {
            isValid = false
            _passwordTextFieldEmpty.value = true
        }
        return isValid
    }
}