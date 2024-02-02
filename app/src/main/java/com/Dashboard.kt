package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Dashboard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        /*---------------------Hooks------------------------*/
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        textView = findViewById(R.id.textView)
        val toolbar: Toolbar = findViewById(R.id.toolbar)

        /*---------------------Tool Bar------------------------*/
        setSupportActionBar(toolbar)

        /*---------------------ActionBarDrawerToggle------------------------*/
        val toggle = setupActionBarDrawerToggle(toolbar)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setupActionBarDrawerToggle(toolbar: Toolbar): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // Handle drawer open state if needed
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the Home menu item click
                textView.text = "Home Clicked"
            }
            R.id.nav_profile -> {
                // Handle the Profile menu item click
                textView.text = "Profile Clicked"
            }
            // Add more cases for other menu items as needed

            // Close the drawer after handling the item click
            //drawerLayout.closeDrawer(GravityCompat.START)

                // Return true to indicate that the item click has been handled
                //return true
        }
        return false
    }


}
