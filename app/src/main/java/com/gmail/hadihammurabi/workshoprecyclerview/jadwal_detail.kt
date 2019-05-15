package com.gmail.hadihammurabi.workshoprecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_jadwal_detail.*

class jadwal_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_detail)

        val kota_id = intent.getStringExtra("kota_id")
        val kota_nama = intent.getStringExtra("kota_nama")
        text_kota_id.text = kota_id
        text_kota_nama.text = kota_nama
    }
}
