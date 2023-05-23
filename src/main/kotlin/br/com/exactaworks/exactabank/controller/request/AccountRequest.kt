package br.com.exactaworks.exactabank.controller.request

data class AccountRequest(
    val name: String,
    val email: String,
    val password: String,
    val cpf: String
)