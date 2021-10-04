package com.rzerocorp.viewmodels.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.rzerocorp.viewmodels.R
import com.rzerocorp.viewmodels.databinding.TestFragmentBinding
import com.rzerocorp.viewmodels.models.User

class TestFragment : Fragment() {
    lateinit var binding: TestFragmentBinding

    private lateinit var viewModel: TestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestFragmentBinding.inflate(inflater, container, false)

        // UI Items

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.getUsers().observe(viewLifecycleOwner, Observer<List<User>> {
            // Update the UI
        })
    }

}