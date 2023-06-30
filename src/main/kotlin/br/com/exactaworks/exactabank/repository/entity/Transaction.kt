package br.com.exactaworks.exactabank.repository.entity

import br.com.exactaworks.exactabank.enums.CategoriaEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    @Column(name = "accountId")
    val accountId: UUID,
    val amount: Double,
    @Enumerated(EnumType.STRING)
    val categoria: CategoriaEnum
)
