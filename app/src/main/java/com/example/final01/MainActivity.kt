package com.example.final01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        Handler().postDelayed({
            val intent= Intent(this, Scr2::class.java)
            startActivity(intent)
        }, 2500)
    }
}