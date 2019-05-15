package com.gmail.hadihammurabi.workshoprecyclerview

import com.gmail.hadihammurabi.workshoprecyclerview.models.KotaAPI
import io.reactivex.Observable
import retrofit2.http.GET

interface API {
    @GET("kota")
    fun getKota(): Observable<KotaAPI>
}
