package br.com.exactaworks.exactabank.repository

import br.com.exactaworks.exactabank.repository.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {

}