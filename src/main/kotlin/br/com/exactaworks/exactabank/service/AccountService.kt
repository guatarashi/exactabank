package br.com.exactaworks.exactabank.service

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse

interface AccountService {

    fun insert(accountRequest: AccountRequest) : AccountResponse
}