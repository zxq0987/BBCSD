package com.example.a6week

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var countTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.textViewCount)

        val Toastbutton = findViewById<Button>(R.id.Toastbutton)
        val Countbutton = findViewById<Button>(R.id.Countbutton)
        val Randombutton = findViewById<Button>(R.id.Randombutton)
        val textMain = findViewById<TextView>(R.id.textMain)

        Toastbutton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("토스트 메시지")
                .setMessage("어떤 것을 원하세요?")
                .setPositiveButton("Count 초기화") { _, _ ->
                    count = 0
                    countTextView.text = count.toString()
                }
                .setNeutralButton("토스트 보기") { _, _ ->
                    Toast.makeText(this, "안뇽뇽!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("다이얼로그 종료") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
            alertDialog.show()
        }

        Countbutton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }

        Randombutton.setOnClickListener {
            val fragment = FragmentOne.newInstance(count)
            val transaction = supportFragmentManager.beginTransaction()

            val formattedString = getString(R.string.Main, count)
            textMain.text = formattedString

            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}
