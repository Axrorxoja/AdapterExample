package com.example.adapterexample

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//ArrayAdapter

private const val TAG = "PersonAdapter"

class PersonAdapter(
    context: Context,
    private val contentData: List<Person>
) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)

    override fun getCount() = contentData.size

    override fun getItem(index: Int) = contentData[index]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(index: Int, itemView: View?, parent: ViewGroup?): View {
        val pair = if (itemView != null) {
            Log.d(TAG, "getView: is not null")
            val vh = itemView.tag as VH
            Pair(itemView, vh)
        } else {
            Log.d(TAG, "getView: is null")
            val rowItem = inflater.inflate(R.layout.item, parent, false)
            val tv = rowItem.findViewById<TextView>(R.id.tv)
            val vh = VH(tv)
            rowItem.tag = vh
            Pair(rowItem, vh)
        }

        val person = getItem(index)
        val vh = pair.second
        vh.tv.text = person.name
        return pair.first
    }

    class VH(
        val tv: TextView
    )

}