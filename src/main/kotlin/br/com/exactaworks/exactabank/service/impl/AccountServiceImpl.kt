package br.com.exactaworks.exactabank.service.impl

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.mapper.AccountMapper
import br.com.exactaworks.exactabank.repository.AccountRepository
import br.com.exactaworks.exactabank.repository.entity.Account
import br.com.exactaworks.exactabank.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) : AccountService {

    override fun save(accountRequest: AccountRequest) : AccountResponse {
        val account = save(accountMapper.requestToAccount(accountRequest))

        return accountMapper.accountToResponse(account)
    }

    override fun save(account: Account) : Account {
        return accountRepository.save(account)
    }
}