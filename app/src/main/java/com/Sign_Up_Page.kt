package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Sign_Up_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        // Declaration variables

        // Declare FirebaseDatabase
        var rootNode: FirebaseDatabase = FirebaseDatabase.getInstance()

        // Declare DatabaseReference
        var reference: DatabaseReference = rootNode.reference



        val regName: TextInputLayout = findViewById(R.id.Full_Name)
        val regUsername: TextInputLayout = findViewById(R.id.username)
        val regEmail: TextInputLayout = findViewById(R.id.Email)
        val regPhone: TextInputLayout = findViewById(R.id.Phoneon)
        val regPassword: TextInputLayout = findViewById(R.id.Password)

        val regBtn: Button = findViewById(R.id.Sign_Up)
        val regToLoginBtn: Button = findViewById(R.id.Login_Page)

        //Save data after you register to the system in Firebase on button click
        // Inside your function or wherever you are using regBtn
        regBtn.setOnClickListener {
            rootNode = FirebaseDatabase.getInstance()
            reference = rootNode.getReference("users")

            reference.setValue("First data storage")

            val name: String = regName.editText?.text.toString()
            val username: String = regUsername.editText?.text.toString()
            val email: String = regEmail.editText?.text.toString()
            val phoneNo: String = regPhone.editText?.text.toString()
            val password: String = regPassword.editText?.text.toString()

            val helperClass = UserHelperClass(name, username, email, phoneNo, password)

            reference.setValue(helperClass)

        }



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