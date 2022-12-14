package br.projeto.apanhagastos.models

data class GastoEmUsuario(
    val nomeGasto: String = "",
    val categoria: String = "",
    val custo: Double = 0.00,

    val nomeUsuario: String = ""
)
