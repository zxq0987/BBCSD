package com.example.a5WEEK

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("생명주기", "SecondActivity onCreate")

        val randomTextView = findViewById<TextView>(R.id.textViewRandom)
        val Backbutton = findViewById<Button>(R.id.Backbutton)

        val count = intent.getIntExtra("count", 0)

        val randomValue = Random.nextInt(0, count + 1)
        randomTextView.text = randomValue.toString()

        Backbutton.setOnClickListener {
            val resultIntent = intent
            resultIntent.putExtra("newCount", randomValue)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("생명주기", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("생명주기", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("생명주기", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("생명주기", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("생명주기", "onDestroy")
    }