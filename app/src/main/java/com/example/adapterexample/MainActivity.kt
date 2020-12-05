package com.example.adapterexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

/*
* 1)create rv
* 2)create rv item view
* 3)mock data
* 4)adapter
* 5)integrate
*
* */
class MainActivity : AppCompatActivity(), OnItemClickListener {

    private val data by lazy { PersonGenerator.generatePersons() }
    private val adapter by lazy { PersonAdapter(this) } // kotlin lazy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRV()

        findViewById<FloatingActionButton>(R.id.fab)
            .setOnClickListener {
                updateData()
            }
    }

    private fun setUpRV() {
        val rvPerson = findViewById<RecyclerView>(R.id.rv_person)
        val gridlayoutManager = GridLayoutManager(this, 2)
        rvPerson.layoutManager = gridlayoutManager
        rvPerson.adapter = adapter
        val decorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvPerson.addItemDecoration(decorator)
        val itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.DOWN or ItemTouchHelper.UP,
                ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    //TODO()
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        adapter.removeByPosition(position)
                    }
                }

            })
        itemTouchHelper.attachToRecyclerView(rvPerson)
    }

    private fun updateData() {
        adapter.submitData(data)
    }

    override fun onItemClick(person: Person) {
        Toast.makeText(this, person.name, Toast.LENGTH_SHORT).show()
    }
}