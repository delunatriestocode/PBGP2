package br.projeto.apanhagastos.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    // Dólar
    @GET("daily/USD-BRL/1")
    fun getUSDtoBRL() : Call<List<Moeda>>

    // Euro
    @GET("last/EUR-BRL")
    fun getEURtoBRL() : Call<List<Moeda>>

    // Libra Esterlina
    @GET("last/GBP-BRL")
    fun getGBPtoBRL() : Call<List<Moeda>>

    // Iene Japonês
    @GET("last/JPY-BRL")
    fun getJPYtoBRL() : Call<List<Moeda>>

    // Dólar Australiano
    @GET("last/AUD-BRL")
    fun getAUDtoBRL() : Call<List<Moeda>>

    // Franco Suíço
    @GET("last/CHF-BRL")
    fun getCHFtoBRL() : Call<List<Moeda>>

    // Dólar Canadense
    @GET("last/CAD-BRL")
    fun getCADtoBRL() : Call<List<Moeda>>

    // Yuan Chinês
    @GET("last/CNY-BRL")
    fun getCNYtoBRL() : Call<List<Moeda>>

    // Peso Argentino
    @GET("last/ARS-BRL")
    fun getARStoBRL() : Call<List<Moeda>>

}