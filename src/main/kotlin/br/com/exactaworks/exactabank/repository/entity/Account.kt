package br.com.exactaworks.exactabank.repository.entity

import jakarta.persistence.Column
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
    @Column(name = "accountNumber")
    val accountNumber: String,
    val password: String,
    var balance: Double,
    val name: String,
    val email: String,
    val cpf: String
)