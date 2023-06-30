package br.com.exactaworks.exactabank.controller

import br.com.exactaworks.exactabank.controller.request.AccountDepositoRequest
import br.com.exactaworks.exactabank.controller.response.AccountDepositoResponse
import br.com.exactaworks.exactabank.facade.AccountTransactionFacade
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("accounts/transaction")
class AccountTransactionController(private val accountTransactionFacade: AccountTransactionFacade) {

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun deposito(@RequestParam(required = false) accountNumber: String?,
                 @RequestParam(required = false) email: String?,
                 @RequestParam(required = false) cpf: String?,
                 @RequestBody @Valid accountDepositoRequest: AccountDepositoRequest): AccountDepositoResponse {
        return accountTransactionFacade.depositSwitch(accountNumber, email, cpf, accountDepositoRequest)
    }
}