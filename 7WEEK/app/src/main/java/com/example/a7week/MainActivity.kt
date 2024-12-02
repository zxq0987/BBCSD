package com.example.a7week

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NameAdapter
    private val nameList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewNames)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NameAdapter(nameList, ::onItemClick, ::onItemLongClick)
        recyclerView.adapter = adapter

        val editTextName: EditText = findViewById(R.id.editTextName)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                nameList.add(name)
                adapter.notifyItemInserted(nameList.size - 1)
                editTextName.text.clear()
            } else {
                Toast.makeText(this, "이름을 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onItemClick(position: Int) {
        val name = nameList[position]

        AlertDialog.Builder(this)
            .setTitle("이름 삭제하기")
            .setMessage("이름을 삭제하시겠습니까?")
            .setPositiveButton("삭제") { _, _ ->
                nameList.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
            .setNegativeButton("취소", null)
            .show()
    }

    private fun onItemLongClick(position: Int) {
        val name = nameList[position]
        val editText = EditText(this)
        editText.setText(name)

        AlertDialog.Builder(this)
            .setTitle("이름 바꾸기")
            .setView(editText)
            .setPositiveButton("확인") { _, _ ->
                val newName = editText.text.toString().trim()
                if (newName.isNotEmpty()) {
                    nameList[position] = newName
                    adapter.notifyItemChanged(position)
                } else {
                    Toast.makeText(this, "이름이 없을 순 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("취소", null)
            .show()
    }
}
