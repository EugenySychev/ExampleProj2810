package com.example.exampleproj2810

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val analytic : AnalyticWrap = AnalyticWrap(application)
        findViewById<Button>(R.id.login).setOnClickListener {
            val userId = findViewById<EditText>(R.id.editTextTextPersonName)
            analytic.login(userId.text.toString())
        }
        findViewById<Button>(R.id.logout).setOnClickListener {
            analytic.logout()
        }
        findViewById<Button>(R.id.send_event).setOnClickListener {
            analytic.sendEvent()
        }
        findViewById<Button>(R.id.sim_crash).setOnClickListener {
            analytic.simCrash()
        }
    }
}