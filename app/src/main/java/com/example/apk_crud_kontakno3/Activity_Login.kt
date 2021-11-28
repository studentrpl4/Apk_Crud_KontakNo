package com.example.apk_crud_kontakno3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity_Login : AppCompatActivity() {
    var nomer = "1234"
    var password = "log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val id_no = findViewById<EditText>(R.id.id_no)
        val id_pass = findViewById<EditText>(R.id.id_pass)
        val press_login = findViewById<Button>(R.id.press_login)
        press_login.setOnClickListener {
            if (id_no.text.toString()
                    .equals(nomer, ignoreCase = true) && id_pass.text.toString()
                    .equals(password, ignoreCase = true)
            ) {
                startActivity(Intent(this@Activity_Login, Activity_Dashboard::class.java))
            } else {
                Toast.makeText(
                    this@Activity_Login,
                    "Nomer telpon atau password salah!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}