package br.projeto.apanhagastos.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    // Dólar
    @GET("daily/USD-BRL/1")
    fun getUSDtoBRL() : Call<List<Moeda>>

    // Euro
    @GET("daily/EUR-BRl/1")
    fun getEURtoBRL() : Call<List<Moeda>>

    // Libra Esterlina
    @GET("daily/GBP-BRl/1")
    fun getGBPtoBRL() : Call<List<Moeda>>

    // Iene Japonês
    @GET("daily/JPY-BRl/1")
    fun getJPYtoBRL() : Call<List<Moeda>>

    // Dólar Australiano
    @GET("daily/AUD-BRl/1")
    fun getAUDtoBRL() : Call<List<Moeda>>

    // Franco Suíço
    @GET("daily/CHF-BRl/1")
    fun getCHFtoBRL() : Call<List<Moeda>>

    // Dólar Canadense
    @GET("daily/CAD-BRl/1")
    fun getCADtoBRL() : Call<List<Moeda>>

    // Yuan Chinês
    @GET("daily/CNY-BRl/1")
    fun getCNYtoBRL() : Call<List<Moeda>>

    // Peso Argentino
    @GET("daily/ARS-BRl/1")
    fun getARStoBRL() : Call<List<Moeda>>




}