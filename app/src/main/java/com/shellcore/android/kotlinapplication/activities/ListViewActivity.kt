package com.shellcore.android.kotlinapplication.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shellcore.android.kotlinapplication.R
import com.shellcore.android.kotlinapplication.adapters.PersonAdapter
import com.shellcore.android.kotlinapplication.models.Person
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter:PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        personList = getPersons()
        adapter = PersonAdapter(this, R.layout.list_view_person, personList)

        lstView.adapter = adapter
    }

    private fun getPersons(): List<Person> {
        return listOf(
                Person("Alejandro", "Lora", 27),
                Person("Benito", "Juarez", 35),
                Person("Carlos", "Ramírez", 43),
                Person("Diego", "González", 18),
                Person("Eleazar", "Miramar", 29),
                Person("Fernando", "Hernández", 49),
                Person("Gustavo", "Pérez", 13),
                Person("Hector", "Cienfuegos", 54),
                Person("Ignacio", "Villa", 28),
                Person("Joaquín", "Soto", 39)
        )
    }
}
