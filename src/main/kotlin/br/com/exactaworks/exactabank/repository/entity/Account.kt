package br.com.exactaworks.exactabank.repository.entity

data class Account(
    var id: String,
    val accountNumber: String?,
    val balance: Double,
    val name: String,
    val email: String,
    val cpf: String
)