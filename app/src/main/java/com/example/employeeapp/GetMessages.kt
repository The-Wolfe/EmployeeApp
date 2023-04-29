package com.example.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import org.json.JSONArray

class GetMessages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_messages)

        val progress=findViewById<ProgressBar>(R.id.progressA)
        val message=findViewById<TextView>(R.id.newMessage)

        val api="https://jsonplaceholder.typicode.com/posts"

//        CREATE INSTANCE(OBJECT) OF ApiHelper class
        val getHelper=ApiHelper(applicationContext)

//        ACCESS THE GET METHOD

        getHelper.get(api,object :ApiHelper.CallBack {
            override fun onSuccess(result: String?) {
                val employees = JSONArray(result.toString())
                println(employees)

                (0 until employees.length()).forEach {
                    val employeeObject = employees.getJSONObject(it)

                    val newMessage = findViewById<TextView>(R.id.newMessage)

                    newMessage.append("User Id:" + employeeObject.get("userId") + "\n")
                    newMessage.append("ID:" + employeeObject.get("id") + "\n")
                    newMessage.append("Title:" + employeeObject.get("title") + "\n")
                    newMessage.append("Body:" + employeeObject.get("body") + "\n")
                    newMessage.append("\n\n\n")

                }

                progress.visibility = View.GONE
            }
        })
    }
}
