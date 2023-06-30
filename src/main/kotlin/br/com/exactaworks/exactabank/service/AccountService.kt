package br.com.exactaworks.exactabank.service

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.repository.entity.Account

interface AccountService{

    fun save(account: Account) : Account

    fun save(accountRequest: AccountRequest): AccountResponse

    fun findById(id: String): AccountResponse

    fun findByAccountNumber(accountNumber: String): Account

    fun findByCpf(cpf: String): Account

    fun findByEmail(email: String): Account
}