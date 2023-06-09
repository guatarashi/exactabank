package br.com.exactaworks.exactabank.controller.response

import br.com.exactaworks.exactabank.enums.CategoriaEnum

data class AccountDepositoResponse(
    val documento: String,
    val tipoDocumento: String,
    val balance: Double,
    val valor: Double,
    val categoria: CategoriaEnum
)
