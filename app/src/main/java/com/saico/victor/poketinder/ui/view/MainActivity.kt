package com.saico.victor.poketinder.ui.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saico.victor.poketinder.R
import com.saico.victor.poketinder.databinding.ActivityMainBinding
import com.saico.victor.poketinder.ui.viewmodel.MainViewModel


class MainActivity : BaseActivity<ActivityMainBinding>
    (ActivityMainBinding::inflate) {

    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }
}