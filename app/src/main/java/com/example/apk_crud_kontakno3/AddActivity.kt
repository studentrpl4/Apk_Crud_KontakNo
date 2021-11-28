package com.example.apk_crud_kontakno3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        ref = FirebaseDatabase.getInstance().getReference("USERS")

        val save = findViewById<Button>(R.id.save)

        save.setOnClickListener {
           savedata()
        }
    }

    private fun savedata() {

        val inputNama = findViewById<EditText>(R.id.inputNama)
        val inputNomer = findViewById<EditText>(R.id.inputNomer)

        val nama = inputNama.text.toString()
        val nomer = inputNomer.text.toString()

        val userId = ref.push().key.toString()
        val user = Users(userId,nama,nomer)


        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Successs",Toast.LENGTH_SHORT).show()
            inputNama.setText("")
            inputNomer.setText("")
        }
    }
}