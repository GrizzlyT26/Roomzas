package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myapplication.R
import com.google.android.material.navigation.NavigationView
import com.login_Page

class Main_Dashboard : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dashboard)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerlayout1)
        val navView : NavigationView = findViewById(R.id.nav_view1)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext,"Home Page Selected",Toast.LENGTH_SHORT).show()
                R.id.nav_Message -> Toast.makeText(applicationContext,"Message Page Selected",Toast.LENGTH_SHORT).show()
                R.id.nav_user -> Toast.makeText(applicationContext,"User Page Selected",Toast.LENGTH_SHORT).show()


                R.id.nav_settings ->{
                    Toast.makeText(applicationContext, "Settings Page Selected", Toast.LENGTH_SHORT).show()

                    // Start the Settings Page activity
                    val intent = Intent(this@Main_Dashboard, Settings::class.java)
                    startActivity(intent)

                    // Finish the current activity if needed
                    finish()
                }
                R.id.nav_rate_us -> Toast.makeText(applicationContext,"Rate Page Selected",Toast.LENGTH_SHORT).show()
                R.id.nav_loggout -> {
                    Toast.makeText(applicationContext, "Logout Page Selected", Toast.LENGTH_SHORT).show()

                    // Start the login_Page activity
                    val intent = Intent(this@Main_Dashboard, login_Page::class.java)
                    startActivity(intent)

                    // Finish the current activity if needed
                    finish()
                }

                R.id.nav_share -> Toast.makeText(applicationContext,"Share Page Selected",Toast.LENGTH_SHORT).show()
                R.id.nav_rate_uss -> Toast.makeText(applicationContext,"Rate Page Selected",Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){

         return true

        }
        return super.onOptionsItemSelected(item)

    }
}