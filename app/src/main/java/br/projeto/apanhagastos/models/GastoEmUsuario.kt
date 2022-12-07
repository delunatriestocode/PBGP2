package br.projeto.apanhagastos.models

data class GastoEmUsuario(
    val nomeGasto: String = "",
    val categoria: String = "",
    val custo: Long = 0L,

    val nomeUsuario: String = ""
)
