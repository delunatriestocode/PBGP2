package br.projeto.apanhagastos.api

import com.google.gson.annotations.SerializedName

data class Moeda(
    @SerializedName("ask")
    val ask: String,
    @SerializedName("bid")
    val bid: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("codein")
    val codein: String,
    @SerializedName("create_date")
    val create_date: String,
    @SerializedName("high")
    val high: String,
    @SerializedName("low")
    val low: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("pctChange")
    val pctChange: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("varBid")
    val varBid: String
)
