package br.com.exactaworks.exactabank.controller.request

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotEmpty

data class AccountDepositoRequest(
    @NotEmpty(message = "A senha não foi preenchida")
    val password: String,
    @DecimalMin(value = "10.00", message = "O valor mínimo é R$ 10,00")
    val valor: Double
)
