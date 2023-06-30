package br.com.exactaworks.exactabank.facade

import br.com.exactaworks.exactabank.controller.request.AccountDepositoRequest
import br.com.exactaworks.exactabank.controller.response.AccountDepositoResponse

interface AccountTransactionFacade {

    fun depositSwitch(accountNumber: String?, email: String?, cpf: String?, accountDepositoRequest: AccountDepositoRequest): AccountDepositoResponse
}