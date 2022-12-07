package br.projeto.apanhagastos.models

data class Gasto (
    val nomeGasto: String = "",
    val categoria: String = "",
    val custo: Double = 0.00,
)
