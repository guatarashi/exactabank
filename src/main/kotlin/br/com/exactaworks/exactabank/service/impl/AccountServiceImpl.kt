package br.com.exactaworks.exactabank.service.impl

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.facade.AccountFacade
import br.com.exactaworks.exactabank.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountFacade: AccountFacade
) : AccountService {

    override fun insert(accountRequest: AccountRequest) : AccountResponse {
        return accountFacade.insert(accountRequest)
    }
}