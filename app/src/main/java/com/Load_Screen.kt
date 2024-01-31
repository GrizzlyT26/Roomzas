package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.myapplication.R

class Load_Screen : AppCompatActivity() {


    private val SPLASH_TIME_OUT = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.run {
            addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        }

        setContentView(R.layout.activity_load_screen)

            //
            val first: View = findViewById(R.id.first_line)
            val second: View = findViewById(R.id.second_line)
            val third: View = findViewById(R.id.third_line)
            val fourth: View = findViewById(R.id.fourth_line)
            val fifth: View = findViewById(R.id.fifth_line)
            val sixth: View = findViewById(R.id.sixth_line)

            //
            val a : TextView = findViewById(R.id.a)
            val   slogan :TextView = findViewById(R.id.tagLine)

            //Declaration of variables and assigning them
            val topAnimation: Animation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
            val bottomAnimation: Animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)
            val middleAnimation: Animation = AnimationUtils.loadAnimation(this,R.anim.middle_animation)

            first.startAnimation(topAnimation)
            second.startAnimation(topAnimation)
            third.startAnimation(topAnimation)
            fourth.startAnimation(topAnimation)
            fifth.startAnimation(topAnimation)
            sixth.startAnimation(topAnimation)

            a.startAnimation(middleAnimation)
            slogan.startAnimation(bottomAnimation)

        Handler().postDelayed({
            val intent = Intent(this@Load_Screen, User_Information::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT.toLong())

    }
}