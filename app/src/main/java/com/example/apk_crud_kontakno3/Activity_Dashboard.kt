package com.example.apk_crud_kontakno3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.firebase.database.*

class Activity_Dashboard : AppCompatActivity() {



    lateinit var ref : DatabaseReference
    lateinit var list : MutableList<Users>
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnAdd = findViewById<Button>(R.id.add)

        btnAdd.setOnClickListener {
            val itent = Intent(this, AddActivity::class.java)
            startActivity(itent)
        }

        ref = FirebaseDatabase.getInstance().getReference("USERS")
        list = mutableListOf()
        listView = findViewById(R.id.listView)

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){

                    for (h in p0.children){
                        val user = h.getValue(Users::class.java)
                        list.add(user!!)
                    }
                    val adapter = Adapter(this@Activity_Dashboard,R.layout.item,list)
                    listView.adapter = adapter
                }
            }
        })
    }
}