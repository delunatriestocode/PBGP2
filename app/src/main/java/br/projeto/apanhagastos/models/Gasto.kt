package br.projeto.apanhagastos.models

data class Gasto (
    val nome: String = "",
    val categoria: String = "",
    val custo: Long = 0L,
)
