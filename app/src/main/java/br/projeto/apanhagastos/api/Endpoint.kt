package br.projeto.apanhagastos.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    // Dólar
    @GET("daily/USD-BRL/1")
    fun getUSDtoBRL() : Call<List<Moeda>>

    // Euro
    @GET("daily/EUR-BRL/1")
    fun getEURtoBRL() : Call<List<Moeda>>

    // Libra Esterlina
    @GET("daily/GBP-BRL/1")
    fun getGBPtoBRL() : Call<List<Moeda>>

    // Iene Japonês
    @GET("daily/JPY-BRL/1")
    fun getJPYtoBRL() : Call<List<Moeda>>

    // Dólar Australiano
    @GET("daily/AUD-BRL/1")
    fun getAUDtoBRL() : Call<List<Moeda>>

    // Franco Suíço
    @GET("daily/CHF-BRL/1")
    fun getCHFtoBRL() : Call<List<Moeda>>

    // Dólar Canadense
    @GET("daily/CAD-BRL/1")
    fun getCADtoBRL() : Call<List<Moeda>>

    // Yuan Chinês
    @GET("daily/CNY-BRL/1")
    fun getCNYtoBRL() : Call<List<Moeda>>

    // Peso Argentino
    @GET("daily/ARS-BRL/1")
    fun getARStoBRL() : Call<List<Moeda>>

}