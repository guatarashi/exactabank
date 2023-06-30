package br.com.exactaworks.exactabank.repository

import br.com.exactaworks.exactabank.repository.entity.Account
import java.util.Optional
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {

    fun findById(id: UUID) : Optional<Account>

    fun findByAccountNumber(accountNumber: String): Optional<Account>

    fun findByCpf(cpf: String): Optional<Account>

    fun findByEmail(email: String): Optional<Account>
}