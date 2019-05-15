package com.gmail.hadihammurabi.workshoprecyclerview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.gmail.hadihammurabi.workshoprecyclerview.models.Kota

class KotaListAdapter(private val activity: Activity, kotas: List<Kota>) : BaseAdapter() {

    private var kotas: List<Kota> = listOf()

    init {
        this.kotas = kotas
    }

    override fun getCount(): Int {
        return this.kotas.count()
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return this.kotas[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vi: View? = convertView
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        vi = inflater.inflate(R.layout.kota_list_item, null)
        val name = vi.findViewById<TextView>(R.id.name)
        name.text = this.kotas[position].nama
        return vi
    }

}