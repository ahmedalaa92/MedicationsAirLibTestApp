package com.example.arlibtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.arlibtest.R
import com.example.arlibtest.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.usernameTextFieldEmpty.observe(viewLifecycleOwner) { shouldShowError ->
            if (shouldShowError) {
                binding.usernameTextField.error = getString(R.string.error_username_empty)
            }
        }

        viewModel.passwordTextFieldEmpty.observe(viewLifecycleOwner) { shouldShowError ->
            if (shouldShowError) {
                binding.passwordTextField.error = getString(R.string.error_password_empty)
            }
        }

        viewModel.navigationToDashboard.observe(viewLifecycleOwner) { shouldNavigateToDashboard ->
            if (shouldNavigateToDashboard) {
                navigateToDashboardFragment()
                viewModel.onNavigationToDashboardDone()
            }
        }

        return binding.root
    }

    private fun navigateToDashboardFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(
            viewModel.usernameText.value.toString().trim()
        )
        findNavController().navigate(action)
    }
}