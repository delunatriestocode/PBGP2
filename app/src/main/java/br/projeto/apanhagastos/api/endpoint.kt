package br.projeto.apanhagastos.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("daily/USD-BRL/1")
    fun getUSDtoBRL() : Call<List<Moeda>>


/*
    @GET("daily/EUR-BRL/1")
    fun getEURtoBRL() : Call<List<Moeda>>
*/


}