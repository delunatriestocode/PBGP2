package br.projeto.apanhagastos.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("json/last/USD-BRL")
    fun getUSDtoBRL() : Call<List<Moeda>>


/*
    @GET("last/EUR-BRL")
    fun getEURtoBRL() : Call<List<Moeda>>
*/


}