package com.example.adapterexample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


private const val TAG = "PersonAdapter"

class PersonAdapter(
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<PersonVH>() {
    private val contentData = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonVH {
        Log.d(TAG, "onCreateViewHolder: ")
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonVH(view, listener)
    }

    override fun onBindViewHolder(holder: PersonVH, position: Int) {
        Log.d(TAG, "onBindViewHolder: $position")
        val person = contentData[position]
        holder.onBind(person)
    }

    fun submitData(newList: List<Person>) {
        val callback = PersonDiffCallback(contentData, newList)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)

        contentData.clear()
        contentData.addAll(newList)

    }

    override fun getItemCount() = contentData.size

    fun removeByPosition(position: Int) {
        val newList = mutableListOf(*contentData.toTypedArray())
        newList.removeAt(position)

        val callback = PersonDiffCallback(contentData,newList)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)

        contentData.clear()
        contentData.addAll(newList)
    }
}