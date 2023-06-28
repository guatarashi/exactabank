package br.com.exactaworks.exactabank.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID,
    val accountNumber: String,
    val balance: Double,
    val name: String,
    val email: String,
    val cpf: String
)