package br.com.exactaworks.exactabank.controller

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("account")
class AccountInsertController(private val accountService: AccountService) {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun insertAccount(@RequestBody accountRequest: AccountRequest) : AccountResponse {
        return accountService.insert(accountRequest);
    }
}