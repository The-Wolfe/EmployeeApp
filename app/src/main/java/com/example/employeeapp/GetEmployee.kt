package com.example.employeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import org.json.JSONArray

class GetEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_employee)

//        GET PROGRESSBAR THEN MAKE IT VISIBLE
        val progress=findViewById<ProgressBar>(R.id.progress)
        progress.visibility= View.VISIBLE

//        STORE THE API CALL ON A VARIABLE

        val api="https://theWolfe.pythonanywhere.com/employees"

//        CREATE INSTANCE(OBJECT) OF ApiHelper class
        val getHelper=ApiHelper(applicationContext)

//        ACCESS THE GET METHOD

        getHelper.get(api,object :ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                val employees= JSONArray(result.toString())
                println(employees)

                (0 until employees.length()).forEach {
                    val employeeObject=employees.getJSONObject(it)

                    val empdata=findViewById<TextView>(R.id.empdata)

                    empdata.append("ID NUMBER:" + employeeObject.get("id_number") +"\n")
                    empdata.append("USERNAME:" + employeeObject.get("username") +"\n")
                    empdata.append("OTHER NAME:" + employeeObject.get("others") +"\n")
                    empdata.append("SALARY:" + employeeObject.get("salary") +"\n")
                    empdata.append("DEPARTMENT:" + employeeObject.get("department") +"\n")
                    empdata.append("\n\n\n")
                }

                progress.visibility= View.GONE
            }
        })





    }
}
