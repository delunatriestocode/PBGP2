package br.projeto.apanhagastos.models

data class Gasto (
    val name: String = "",
    val categoria: String = "",
    val custo: Long = 0L,
)
