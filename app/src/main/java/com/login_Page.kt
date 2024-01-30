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

        //val LoginButton = findViewById<Button>(R.id.login)
        //val No_acc = findViewById<Button>(R.id.NoAcc)
        //val Forgot_Password = findViewById<Button>(R.id.Forgot_Pass)

        // Set to link to the Sign Up Page
        //LoginButton.setOnClickListener {
            //val intent = Intent(this, Sign_Up_Page::class.java)
            //startActivity(intent) // Add this line to start the activity
        //}
        // Set to link to the Sign Up Page
        //No_acc.setOnClickListener {
           // val intent = Intent(this, Sign_Up_Page::class.java)
            //startActivity(intent) // Add this line to start the activity
        //}
        // Set to link to the Forgot Password Page
        //Forgot_Password.setOnClickListener {
            //val intent = Intent(this, Forget_password::class.java)
            //startActivity(intent) // Add this line to start the activity
        //}
        val callSignUp = findViewById<Button>(R.id.login)

        callSignUp.setOnClickListener {
            val intent = Intent(this@login_Page, Sign_Up_Page::class.java)
            startActivity(intent)
        }
        val No_Acc = findViewById<Button>(R.id.NoAcc)

        No_Acc.setOnClickListener {
            val intent = Intent(this@login_Page, Sign_Up_Page::class.java)
            startActivity(intent)
        }

        val Forgot_Password = findViewById<Button>(R.id.Forgot_Pass)

            Forgot_Password.setOnClickListener {
                val intent = Intent(this@login_Page, Forget_password::class.java)
                startActivity(intent)
            }
    }
}