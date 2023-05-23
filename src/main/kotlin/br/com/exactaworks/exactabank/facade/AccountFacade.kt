package br.com.exactaworks.exactabank.facade

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse

interface AccountFacade {

    fun insert(accountRequest: AccountRequest) : AccountResponse
}