package com.shellcore.android.kotlinapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.shellcore.android.kotlinapplication.models.Person
import kotlinx.android.synthetic.main.list_view_person.view.*

/**
 * Created by MOGC on 29/01/2018.
 */
class PersonAdapter(val context: Context,
                    val layout: Int,
                    val list: List<Person>) : BaseAdapter() {

    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: PersonViewHolder

        if (convertView == null) {
            view = mInflator.inflate(layout, parent, false)
            viewHolder = PersonViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as PersonViewHolder
        }

        val fullName = "${list[position].firstName} ${list[position].lastName}"
        viewHolder.txtFullName.text = fullName
        viewHolder.txtAge.text = "${list[position].age}"

        return view
    }
}

private class PersonViewHolder(view: View) {

    val txtFullName: TextView = view.txtName
    val txtAge: TextView = view.txtAge
}