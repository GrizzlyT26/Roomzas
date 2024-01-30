package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class Sign_Up_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        //val SignUp = findViewById<Button>(R.id.Sign_Up)
        //val Already_Acc = findViewById<Button>(R.id.Login_Page)

        //SignUp.setOnClickListener {
            //val intent = Intent(this, Sign_Up_Page::class.java)
            //startActivity(intent) // Add this line to start the activity
        //}
        //Already_Acc.setOnClickListener {
            // intent = Intent(this, login_Page::class.java)
            //startActivity(intent) // Add this line to start the activity
        //}

        val SignUp = findViewById<Button>(R.id.Sign_Up)

        SignUp.setOnClickListener {
            val intent = Intent(this@Sign_Up_Page, login_Page::class.java)
            startActivity(intent)
        }

        val Login = findViewById<Button>(R.id.Login_Page)

        Login.setOnClickListener {
            val intent = Intent(this@Sign_Up_Page, login_Page::class.java)
            startActivity(intent)
        }
    }
}