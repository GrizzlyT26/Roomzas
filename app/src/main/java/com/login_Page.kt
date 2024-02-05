package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class login_Page : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_login_page)
        
        val callSignUp = findViewById<Button>(R.id.login)
        val Forgot_Password = findViewById<Button>(R.id.Forgot_Pass)

        callSignUp.setOnClickListener {
            val intent = Intent(this@login_Page, Load_Screen::class.java)
            startActivity(intent)
        }
        val No_Acc = findViewById<Button>(R.id.NoAcc)

        No_Acc.setOnClickListener {
            val intent = Intent(this@login_Page, Sign_Up_Page::class.java)
            startActivity(intent)
        }
            Forgot_Password.setOnClickListener {
                val intent = Intent(this@login_Page, Forget_password::class.java)
                startActivity(intent)
            }

    }
}