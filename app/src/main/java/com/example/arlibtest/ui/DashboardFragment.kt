package com.example.arlibtest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.arlibtest.R
import com.example.arlibtest.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.medicationsRecycler.adapter =
            MedicationsListAdapter(MedicationsListAdapter.OnClickListener {
                val action =
                    DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(it)
                findNavController().navigate(action)
            })

        val username = DashboardFragmentArgs.fromBundle(requireArguments()).username
        viewModel.setUserName(username)
        return binding.root
    }
}