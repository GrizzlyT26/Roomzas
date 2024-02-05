package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Sign_Up_Page : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private val emailPattern = ("^[\\w.-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}\$")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val regName: TextInputLayout = findViewById(R.id.Full_Name)
        val regUsername: TextInputLayout = findViewById(R.id.username)
        val regEmail: TextInputLayout = findViewById(R.id.Email)
        val reConPassword: TextInputLayout = findViewById(R.id.con_password)
        val regPassword: TextInputLayout = findViewById(R.id.Password)

        val regBtn: Button = findViewById(R.id.Sign_Up)
        val regToLoginBtn: Button = findViewById(R.id.Login_Page)

        regBtn.setOnClickListener {
            val name = regName.editText!!.text.toString()
            val userName = regUsername.editText!!.text.toString()
            val email = regEmail.editText!!.text.toString()
            val con_password = reConPassword.editText!!.text.toString()
            val password = regPassword.editText!!.text.toString()


            if (name.isEmpty() || userName.isEmpty() || email.isEmpty() || con_password.isEmpty() || password.isEmpty()){
                if (name.isEmpty()){
                    regName.error = "User Full Name Required!!!"
                }
                if (userName.isEmpty()){
                    regUsername.error = "Username Required!!!"
                }
                if (email.isEmpty()){
                    regEmail.error = "User Email Required!!!"
                }
                if (password.isEmpty()){
                    regPassword.error = "User Password Required!!!"
                }
                if (con_password.isEmpty()){
                    reConPassword.error = "User Confirmation Password  Required!!!"
                }
                Toast.makeText(this, "Enter valid details", Toast.LENGTH_SHORT).show()

            }else if (!email.matches(emailPattern.toRegex())){
                regEmail.error = "Enter valid email address"
                Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show()
            }else if (password.length< 6){
                regPassword.error = "Password must contain or consist of more than 6 characters and more "
                Toast.makeText(this, "Enter password more than 6 characters", Toast.LENGTH_SHORT).show()
            }else if (password != con_password){
                reConPassword.error = "Password doesn't match "
                Toast.makeText(this, "Enter password that matches the previous", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                       val databaseRef = database.reference.child("users").child(auth.currentUser!!.uid)
                        val users : Users = Users(name, email, auth.currentUser!!.uid)

                        databaseRef.setValue(users).addOnCompleteListener {
                            if (it.isSuccessful){
                                val intent = Intent(this@Sign_Up_Page, login_Page::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this, "Oops something went wrong, try again", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }else{
                        Toast.makeText(this, "Oops something went wrong, try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }




        val SignUp = findViewById<Button>(R.id.Sign_Up)

        //SignUp.setOnClickListener {
            // intent = Intent(this@Sign_Up_Page, login_Page::class.java)
            //startActivity(intent)
        //}

        val Login = findViewById<Button>(R.id.Login_Page)

        Login.setOnClickListener {
            val intent = Intent(this@Sign_Up_Page, login_Page::class.java)
            startActivity(intent)
        }
    }

}