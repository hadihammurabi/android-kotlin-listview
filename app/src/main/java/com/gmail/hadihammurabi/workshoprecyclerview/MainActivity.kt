package com.gmail.hadihammurabi.workshoprecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.R.layout.simple_list_item_1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languages = listOf("Javascript", "Python", "PHP", "Ruby")
        listview.adapter = ArrayAdapter(this, simple_list_item_1, languages)

        listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, "Anda memilih ${languages[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}
