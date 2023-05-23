package br.com.exactaworks.exactabank.mapper

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.repository.entity.Account
import java.util.*
import org.springframework.stereotype.Component

@Component
class RequestToAccountMapper(): Mapper<AccountRequest, Account> {

    override fun map(t: AccountRequest): Account {
        return Account(
            id = UUID.randomUUID().toString(),
            accountNumber = "",
            balance = 0.0,
            name = t.name,
            email = t.email,
            cpf = t.cpf
        )
    }
}