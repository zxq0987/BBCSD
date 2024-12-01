package com.example.a5WEEK

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.a5WEEK.SecondActivity
import com.example.a5week.R

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var countTextView: TextView

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val newCount = result.data?.getIntExtra("newCount", count)
            newCount?.let {
                count = it
                countTextView.text = count.toString()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.textViewCount)

        val Toastbutton = findViewById< Button>(R.id.Toastbutton)
        val Countbutton = findViewById<Button>(R.id.Countbutton)
        val Randombutton = findViewById<Button>(R.id.Randombutton)

        Toastbutton.setOnClickListener {
            Toast.makeText(this, "Hello, Toast!", Toast.LENGTH_SHORT).show()
        }

        Countbutton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }

        Randombutton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("count", count)
            activityResultLauncher.launch(intent)
        }
    }
}