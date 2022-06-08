package com.example.starwars.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.starwars.R
import com.example.starwars.app.ui.adapters.HomeScreenAdapter
import com.example.starwars.databinding.FragmentHomeScreenBinding


class HomeScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //binding
        val binding = FragmentHomeScreenBinding.inflate(layoutInflater)

        Glide.with(requireContext())
            .load("https://images.unsplash.com/photo-1586136194012-35ceaddbd773?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80")
            .circleCrop()
            .into(binding.userProfileImage)

        val homeAdapter = HomeScreenAdapter()
        binding.characterRecyclerView.adapter = homeAdapter
        binding.characterRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }


}