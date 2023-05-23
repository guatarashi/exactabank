package br.com.exactaworks.exactabank.facade.impl

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.facade.AccountFacade
import br.com.exactaworks.exactabank.mapper.*
import br.com.exactaworks.exactabank.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountFacadeImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) : AccountFacade {

        override fun insert(accountRequest: AccountRequest): AccountResponse {
            val account = accountMapper.requestToAccount(accountRequest)
            val insert = accountRepository.insert(account)

            return accountMapper.accountToResponse(insert)
    }

}