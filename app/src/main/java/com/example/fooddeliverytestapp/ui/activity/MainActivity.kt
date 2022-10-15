package com.example.fooddeliverytestapp.ui.activity

import android.app.AlertDialog
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.fooddeliverytestapp.R
import com.example.fooddeliverytestapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var popupMenu: PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_menu, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        initPopupMenu()
        initClickListeners()

        navView.setupWithNavController(navController)
    }

    private fun initPopupMenu() {
        with(binding) {
            popupMenu = PopupMenu(this@MainActivity, cityBtn)
            popupMenu.menuInflater.inflate(R.menu.city_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener()
            {
                true
            }
        }
    }

    private fun initClickListeners() {
        with(binding) {
            cityBtn.setOnClickListener {
                popupMenu.show()
            }
            qrBtn.setOnClickListener {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Автор")
                    .setMessage("Камиль Гареев\nGithub: github.com/AvanNorth")
                    .setNegativeButton("Ок", null)
                    .show()
            }
        }
    }
}