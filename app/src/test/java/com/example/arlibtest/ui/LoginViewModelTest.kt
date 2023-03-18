package com.example.arlibtest.ui

import android.text.TextUtils
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel

    @get:Rule
    val instantTaskExecRule = InstantTaskExecutorRule()


    @Before
    fun setup() {
        viewModel = LoginViewModel()
    }

    @Test
    fun testValidateUsernameAndPassword_WithEmptyUserNameAndPasswordValue_VerifyIsNotValid() {
        val emptyString = ""
        val valueString = "Value"
        viewModel.usernameText.value = emptyString
        viewModel.passwordText.value = valueString

        mockkStatic(TextUtils::class)
        every { TextUtils.isEmpty(emptyString) } returns true
        every { TextUtils.isEmpty(valueString) } returns false
        val isValid = viewModel.validateUsernameAndPassword()

        assertEquals(false, isValid)
    }

    @Test
    fun testValidateUsernameAndPassword_WithUserNameAndPasswordValue_VerifyIsValid() {
        val emptyString = ""
        val valueString = "Value"
        viewModel.usernameText.value = valueString
        viewModel.passwordText.value = valueString

        mockkStatic(TextUtils::class)
        every { TextUtils.isEmpty(emptyString) } returns true
        every { TextUtils.isEmpty(valueString) } returns false
        val isValid = viewModel.validateUsernameAndPassword()

        assertEquals(true, isValid)
    }

    @Test
    fun testOnSignInButtonClicked_WithUserNameAndPasswordValue_VerifyNavigationToDashboardIsTrue() {
        val emptyString = ""
        val valueString = "Value"
        viewModel.usernameText.value = valueString
        viewModel.passwordText.value = valueString

        mockkStatic(TextUtils::class)
        every { TextUtils.isEmpty(emptyString) } returns true
        every { TextUtils.isEmpty(valueString) } returns false
        viewModel.onSignInButtonClicked()

        assertEquals(true, viewModel.navigationToDashboard.value)
    }

    @Test
    fun testOnSignInButtonClicked_WithEmptyUserNameAndPasswordValue_VerifyNavigationToDashboardIsFalse() {
        val emptyString = ""
        val valueString = "Value"
        viewModel.usernameText.value = emptyString
        viewModel.passwordText.value = valueString

        mockkStatic(TextUtils::class)
        every { TextUtils.isEmpty(emptyString) } returns true
        every { TextUtils.isEmpty(valueString) } returns false
        viewModel.onSignInButtonClicked()

        assertEquals(false, viewModel.navigationToDashboard.value)
    }

}