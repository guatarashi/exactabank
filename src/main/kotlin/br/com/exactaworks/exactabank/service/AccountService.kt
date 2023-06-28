package br.com.exactaworks.exactabank.service

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.repository.entity.Account

interface AccountService {

    fun save(accountRequest: AccountRequest) : AccountResponse

    fun save(account: Account) : Account
}