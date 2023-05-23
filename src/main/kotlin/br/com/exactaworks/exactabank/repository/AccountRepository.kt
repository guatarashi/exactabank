package br.com.exactaworks.exactabank.repository

import br.com.exactaworks.exactabank.repository.entity.Account
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
class AccountRepository {

    private val accounts: List<Account> = ArrayList()

    fun insert(account: Account) : Account {
        account.id = UUID.randomUUID().toString()

        accounts.plus(account)

        return account
    }
}