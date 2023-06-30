package br.com.exactaworks.exactabank.repository

import br.com.exactaworks.exactabank.repository.entity.Transaction
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, UUID> {
}