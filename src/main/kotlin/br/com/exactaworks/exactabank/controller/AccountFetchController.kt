package br.com.exactaworks.exactabank.controller

import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("accounts")
class AccountFetchController(private val accountService: AccountService) {

    @GetMapping("{id}")
    fun featchAccount(@PathVariable id: String) : AccountResponse {
        return accountService.findById(id)
    }
}