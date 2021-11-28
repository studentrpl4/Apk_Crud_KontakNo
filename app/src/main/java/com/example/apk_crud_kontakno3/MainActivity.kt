package com.example.apk_crud_kontakno3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent= Intent( this@MainActivity, Activity_Login::class.java)
            startActivity(intent)
            finish()

        }, 3000)

    }
}