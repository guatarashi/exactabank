package br.com.exactaworks.exactabank.service.impl

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.exception.NotFoundException
import br.com.exactaworks.exactabank.mapper.AccountMapper
import br.com.exactaworks.exactabank.repository.AccountRepository
import br.com.exactaworks.exactabank.repository.entity.Account
import br.com.exactaworks.exactabank.service.AccountService
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper
) : AccountService {

    override fun save(account: Account) : Account {
        return accountRepository.save(account)
    }

    override fun save(accountRequest: AccountRequest) : AccountResponse {
        val account = save(accountMapper.requestToAccount(accountRequest))

        return accountMapper.accountToResponse(account)
    }

    override fun findById(id: String): AccountResponse {
        return accountRepository.findById(UUID.fromString(id))
            .map { accountMapper.accountToResponse(it) }
            .orElseThrow{ NotFoundException("Account not found") }
    }

    override fun findByAccountNumber(accountNumber: String): Account {
        return accountRepository.findByAccountNumber(accountNumber)
            .orElseThrow{ NotFoundException("Account not found")}
    }

    override fun findByCpf(cpf: String): Account {
        return accountRepository.findByCpf(cpf)
            .orElseThrow{ NotFoundException("Account not found")}
    }

    override fun findByEmail(email: String): Account {
        return accountRepository.findByEmail(email)
            .orElseThrow{ NotFoundException("Account not found")}
    }
}