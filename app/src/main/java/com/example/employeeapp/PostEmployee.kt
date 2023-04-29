package com.example.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONObject

class PostEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_employee)

//        Find the 5 EditTexts and 1 button based on the id
//        set onClick listener to button
//        Incase of click:put the data on the edittext to a JASONObject
//        set to the API
//        Handle the Response back

        val id_number = findViewById<EditText>(R.id.id_number)
        val username = findViewById<EditText>(R.id.username)
        val others = findViewById<EditText>(R.id.others)
        val salary = findViewById<EditText>(R.id.salary)
        val department = findViewById<EditText>(R.id.department)

        val buttonSave = findViewById<Button>(R.id.saveEmployee)
        buttonSave.setOnClickListener {
            val payload = JSONObject()

            payload.put("id_number",id_number.text.toString())
            payload.put("username",username.text.toString())
            payload.put("others",others.text.toString())
            payload.put("salary",salary.text.toString())
            payload.put("department",department.text.toString())

            val api="https://theWolfe.pythonanywhere.com/employees"

//            call the loopj client
            val helper=ApiHelper(applicationContext)
            helper.post(api,payload)

        }
    }
}