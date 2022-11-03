package com.example.parcialtp3grupo4.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.parcialtp3grupo4.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navController = findNavController(R.id.hostFragment)

        drawerLayout = findViewById(R.id.drawer_layout)

        // For Navigation UP
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        //Muestro el drawer navigation (la hamburguesa), pero no le doy ninguna action!

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        //Aca si le doy la action y permito navegar por el el navController
        NavigationUI.setupWithNavController(navigation_view, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)

    }

}