package br.com.exactaworks.exactabank.service.impl

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.exception.NotFoundException
import br.com.exactaworks.exactabank.mapper.AccountMapper
import br.com.exactaworks.exactabank.repository.AccountRepository
import br.com.exactaworks.exactabank.service.AccountService
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) : AccountService {

    override fun save(accountRequest: AccountRequest) : AccountResponse {
        val account = accountRepository.save(accountMapper.requestToAccount(accountRequest))

        return accountMapper.accountToResponse(account)
    }

    override fun findById(id: String): AccountResponse {
        return accountRepository.findById(UUID.fromString(id))
            .map { t -> accountMapper.accountToResponse(t) }
            .orElseThrow{ NotFoundException("Account not found") }
    }
}