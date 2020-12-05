package com.example.adapterexample

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

/*
* 1)create lv
* 2)create lv item view
* 3)mock data
* 4)adapter
* 5)integrate
*
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lv = findViewById<ListView>(R.id.lv)
        val adapter = PersonAdapter(this, PersonGenerator.generatePersons())
        lv.adapter = adapter

        lv.setOnItemClickListener { adapterView, view, i, l ->

        }
    }
}