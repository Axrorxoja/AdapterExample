package com.example.adapterexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


private const val TAG = "PersonAdapter"

class PersonAdapter(
    private val listener: OnItemClickListener,
    private val contentData: List<Person>
) : RecyclerView.Adapter<PersonVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonVH {
        Log.d(TAG, "onCreateViewHolder: ")
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonVH(view,listener)
    }

    override fun onBindViewHolder(holder: PersonVH, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        val person = contentData[position]
        holder.onBind(person)
    }

    override fun getItemCount() = contentData.size
}