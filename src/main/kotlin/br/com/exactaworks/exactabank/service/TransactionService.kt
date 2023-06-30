package br.com.exactaworks.exactabank.service

import br.com.exactaworks.exactabank.repository.entity.Transaction

interface TransactionService {

    fun save(transaction: Transaction): Transaction

    fun findAllByAccountId(uuid: String): List<Transaction>
}