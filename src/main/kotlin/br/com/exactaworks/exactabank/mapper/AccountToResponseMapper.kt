package br.com.exactaworks.exactabank.mapper

import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.repository.entity.Account
import org.springframework.stereotype.Component

@Component
class AccountToResponseMapper(): Mapper<Account, AccountResponse> {

    override fun map(t: Account): AccountResponse {
        return AccountResponse(id = t.id,
        accountNumber = t.accountNumber,
        balance = t.balance,
        name = t.name,
        email = t.email,
        cpf = t.cpf)
    }
}