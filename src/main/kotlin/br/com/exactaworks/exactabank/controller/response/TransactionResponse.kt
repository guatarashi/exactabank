package br.com.exactaworks.exactabank.controller.response

import br.com.exactaworks.exactabank.enums.CategoriaEnum

data class TransactionResponse(
    val id: String,
    val accountId: String,
    val amount: Double,
    val categoria: CategoriaEnum
)
