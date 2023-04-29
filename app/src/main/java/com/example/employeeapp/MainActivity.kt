package com.example.employeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Find button by id
//        set OnclickListener to the button
//        toast a message to identify the clicked

//        project setup
//        1.internet Permission->manifest
//        2.Third Party Library:created by a third party developer(Add Dependencies)
//          Grandle Scripts:used to manage third party libraries
//          loopj->James Smith:perform http request
//          retrofit->
//        3.Get the ApiHelper class-> implemented post,get,put,delete using the loopj dependency
//
//        POST
        val btnPost = findViewById<Button>(R.id.postbtn)
        btnPost.setOnClickListener {
            Toast.makeText(this, "BUTTON POST CLICKED", Toast.LENGTH_LONG).show()
            val intentPost = Intent(applicationContext, PostEmployee::class.java)
            startActivity(intentPost)
        }

        val btnGet = findViewById<Button>(R.id.getbtn)
        btnGet.setOnClickListener {
            Toast.makeText(this, "BUTTON GET CLICKED", Toast.LENGTH_LONG).show()
            val intentGet = Intent(applicationContext, GetEmployee::class.java)
            startActivity(intentGet)
        }

        val btnPut = findViewById<Button>(R.id.putbtn)
        btnPut.setOnClickListener {
            Toast.makeText(this, "BUTTON PUT CLICKED", Toast.LENGTH_LONG).show()
            val intentUpdate = Intent(applicationContext, UpdateEmployee::class.java)
            startActivity((intentUpdate))
        }

        val btnDel = findViewById<Button>(R.id.delbtn)
        btnDel.setOnClickListener {
            Toast.makeText(this, "BUTTON DELETE CLICKED", Toast.LENGTH_LONG).show()
            val intentDelete = Intent(applicationContext, DeleteEmployee::class.java)
            startActivity(intentDelete)

        }

        val btnMess= findViewById<Button>(R.id.getmess)
        btnMess.setOnClickListener {
            Toast.makeText(this, "BUTTON GET MESSAGES CLICKED", Toast.LENGTH_LONG).show()
            val intentMessages = Intent(applicationContext, GetMessages::class.java)
            startActivity(intentMessages)

        }


    }
}


