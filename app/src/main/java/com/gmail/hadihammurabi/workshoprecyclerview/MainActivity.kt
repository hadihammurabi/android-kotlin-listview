package com.gmail.hadihammurabi.workshoprecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.R.layout.simple_list_item_1
import android.content.Intent
import android.util.Log
import com.gmail.hadihammurabi.workshoprecyclerview.models.Kota
import com.gmail.hadihammurabi.workshoprecyclerview.models.KotaAPI
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val api = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.banghasan.com/sholat/format/json/")
        .build().create(API::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getKota()
    }

    fun getKota() {
        var kotas: List<Kota> = listOf()
        api.getKota()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    kotas = result.kota

//                    val kotastring: List<String> = kotas.map { kota -> kota.nama }

                    listview.adapter = KotaListAdapter(this, kotas)

                    listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                        val intent = Intent(applicationContext, jadwal_detail::class.java)
                        intent.putExtra("kota_id", kotas[position].id)
                        intent.putExtra("kota_nama", kotas[position].nama)
                        startActivity(intent)
                    }
                },
                { error -> Log.e("ERROR", error.message) }
            )
    }

}
