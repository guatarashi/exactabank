package br.com.exactaworks.exactabank.facade.impl

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.facade.AccountFacade
import br.com.exactaworks.exactabank.mapper.AccountToResponseMapper
import br.com.exactaworks.exactabank.mapper.RequestToAccountMapper
import br.com.exactaworks.exactabank.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountFacadeImpl(
    private val accountRepository: AccountRepository,
    private val requestToAccountMapper: RequestToAccountMapper,
    private val accountToResponseMapper: AccountToResponseMapper
) : AccountFacade {

        override fun insert(accountRequest: AccountRequest): AccountResponse {
            val account = requestToAccountMapper.map(accountRequest)
            val insert = accountRepository.insert(account)

            return accountToResponseMapper.map(insert)
    }

}