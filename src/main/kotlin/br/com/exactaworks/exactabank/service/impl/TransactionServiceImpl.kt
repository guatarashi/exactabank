package br.com.exactaworks.exactabank.service.impl

import br.com.exactaworks.exactabank.repository.TransactionRepository
import br.com.exactaworks.exactabank.repository.entity.Transaction
import br.com.exactaworks.exactabank.service.TransactionService
import java.util.UUID

class TransactionServiceImpl(
    private val transactionRepository: TransactionRepository
): TransactionService {

    override fun save(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)
    }

    override fun findAllByAccountId(uuid: String): List<Transaction> {
        return transactionRepository.findAllById(listOf(UUID.fromString(uuid)))
    }
}