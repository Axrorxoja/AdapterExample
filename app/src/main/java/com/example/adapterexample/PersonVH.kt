package com.example.adapterexample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonVH(
    view: View,
    private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(view) {
    private val tvName: TextView = view.findViewById(R.id.tv_name)
    private val tvSurName: TextView = view.findViewById(R.id.tv_sur_name)
    private var person: Person? = null

    init {
        itemView.setOnClickListener {
            listener.onItemClick(person!!)
        }
    }

    fun onBind(person: Person) {
        this.person = person
        tvName.text = person.name
        tvSurName.text = person.surName
    }
}