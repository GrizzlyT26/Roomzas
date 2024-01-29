package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login_page)

        val LoginButton = findViewById<Button>(R.id.login)
        val No_acc = findViewById<TextView>(R.id.NoAcc)

        // Set an OnClickListener for the Button
        LoginButton.setOnClickListener {
            val intent = Intent(this, Sign_Up_Page::class.java)
        }

        LoginButton.setOnClickListener {
            val intent = Intent(this, Sign_Up_Page::class.java)
        }
    }
}