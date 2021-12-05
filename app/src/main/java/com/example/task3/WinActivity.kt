package com.example.task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        var inputSolution=intent.getIntExtra("numberIs",0)
        findViewById<TextView>(R.id.winNumber).text="$inputSolution"
    }
}