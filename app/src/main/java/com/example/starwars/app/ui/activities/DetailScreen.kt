package com.example.starwars.app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.starwars.R
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.ui.viewmodels.DetailScreenViewModel
import com.example.starwars.databinding.ActivityDetailScreenBinding

class DetailScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val character_data = intent.getParcelableExtra<PeoplePresentation>("character-data")

        val viewModel = ViewModelProvider(this).get(DetailScreenViewModel::class.java)

        binding.character = character_data

    }
}