package br.com.exactaworks.exactabank.controller.response

data class AccountResponse(
    val id: String,
    val accountNumber: String?,
    val balance: Double,
    val name: String,
    val email: String,
    val cpf: String
)