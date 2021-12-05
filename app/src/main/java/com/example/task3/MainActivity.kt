package com.example.task3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var number= Random.nextInt(0,1000)
    var count=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickButton=findViewById<Button>(R.id.clickButton)
        val inputValue=findViewById<TextInputLayout>(R.id.dynamicText)
        val userGuess=findViewById<TextView>(R.id.textView2)

        clickButton.setOnClickListener {
            try {


                val inputGuess = inputValue.editText?.text.toString()
                val answerGuess=Integer.parseInt(inputGuess)

                val answer=
                if (answerGuess < 0) {
                    count++
                    "Enter an positive number"
                } else if (answerGuess > number) {
                    count++
                     "NO :)) My number is smaller"
                } else if (answerGuess < number) {
                    count++
                    "NO:))My number is larger"
                } else {
                    val winScreenIntent=Intent(this,WinActivity::class.java)
                    winScreenIntent.putExtra("numberIs",number)
                    startActivity(winScreenIntent)
                    "you Won"
                }
                userGuess.text="$answer"
                if(count==12)
                {
                    val lostScreenIntent=Intent(this,looseActivity::class.java)
                    lostScreenIntent.putExtra("numberIs",number)
                    startActivity(lostScreenIntent)
                }
            }
            catch (e:Exception)
            {
                userGuess.text="Please enter the number"
            }
        }
    }
}