package com.example.adapterexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/*
* 1)create rv
* 2)create rv item view
* 3)mock data
* 4)adapter
* 5)integrate
*
* */
class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvPerson = findViewById<RecyclerView>(R.id.rv_person)
        val adapter = PersonAdapter(this, PersonGenerator.generatePersons())
        rvPerson.adapter = adapter
        val decorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvPerson.addItemDecoration(decorator)
        //DiffUtil
    }

    override fun onItemClick(person: Person) {
        Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
    }
}