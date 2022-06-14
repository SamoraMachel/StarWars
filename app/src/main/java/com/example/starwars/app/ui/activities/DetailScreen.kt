package com.example.starwars.app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.starwars.R
import com.example.starwars.app.models.PeoplePresentation
import com.example.starwars.app.models.PlanetPresentation
import com.example.starwars.app.models.SpeciePresentation
import com.example.starwars.app.ui.viewmodels.DetailScreenViewModel
import com.example.starwars.app.utils.Resource
import com.example.starwars.app.utils.Status
import com.example.starwars.databinding.ActivityDetailScreenBinding

class DetailScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val character_data = intent.getParcelableExtra<PeoplePresentation>("character-data")

        val viewModel = ViewModelProvider(this).get(DetailScreenViewModel::class.java)
        viewModel.characterData.value = character_data

        binding.character = character_data

        fun <T> collectData(collection : LiveData<Resource<T>>, function : (T) -> Unit) {
            lifecycleScope.launchWhenStarted {
                collection.observe(this@DetailScreen) {
                    when(it.status) {
                        Status.SUCCESS -> {
                            function
                        }
                        else -> {
                        }
                    }

                }
            }
        }

        collectData<PlanetPresentation>(viewModel.planetData) {
            binding.planet = it
        }

        collectData<SpeciePresentation>(viewModel.specieData) {
            binding.specie = it
        }

    }


}