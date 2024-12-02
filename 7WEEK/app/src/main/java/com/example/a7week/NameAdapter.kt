package com.example.a7week

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdapter(
    private val nameList: List<String>,
    private val onItemClick: (Int) -> Unit,
    private val onItemLongClick: (Int) -> Unit
) : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(nameList[position])
    }

    override fun getItemCount(): Int = nameList.size

    inner class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        fun bind(name: String) {
            textViewName.text = name

            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }

            itemView.setOnLongClickListener {
                onItemLongClick(adapterPosition)
                true
            }
        }
    }
}
